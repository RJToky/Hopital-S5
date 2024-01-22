package com.hopital.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import it.ssc.pl.milp.LP;
import it.ssc.pl.milp.Solution;
import it.ssc.pl.milp.SolutionType;
import it.ssc.pl.milp.Variable;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medicaments")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private double prix;

    @OneToMany(mappedBy = "medicament")
    private List<EffetMedicament> effetsMedicaments;

    public static ArrayList<VMedicamentSymptome> maxQuantite(ArrayList<VMedicamentSymptome> medicamentsSymptomes) {
        ArrayList<VMedicamentSymptome> medicaments = new ArrayList<VMedicamentSymptome>();
        medicaments.addAll(medicamentsSymptomes);

        // Trier par quantite
        medicaments.sort(
                (VMedicamentSymptome m1, VMedicamentSymptome m2) -> Double.compare(m2.getQuantite(), m1.getQuantite()));

        return medicaments;
    }

    public static double getPrixTotal(ArrayList<VMedicamentSymptome> medicamentsSymptomes) {
        double prixTotal = 0.0;
        for (VMedicamentSymptome vMedicamentSymptome : medicamentsSymptomes) {
            prixTotal += vMedicamentSymptome.getPrixTotal();
        }
        return prixTotal;
    }

    public static List<Medicament> getMedicamentsByAge(EntityManager entityManager, int age) {
        String sql = """
                    select m.*
                    from medicaments m
                    join v_medicaments_symptomes vms on vms.id_medicament = m.id
                    where
                        :age between vms.age_debut and vms.age_fin
                        and vms.effet > 0
                        group by m.id
                """;
        Query query = entityManager.createNativeQuery(sql, Medicament.class);
        query.setParameter("age", age);

        return query.getResultList();
    }

    public static ArrayList<VMedicamentSymptome> connaitreMedicamentsMoinsCher(EntityManager entityManager,
            ArrayList<Symptome> symptomesEntrees, int age) {

        ArrayList<VMedicamentSymptome> result = new ArrayList<VMedicamentSymptome>();
        ArrayList<Symptome> symptomes = new ArrayList<Symptome>();
        symptomes.addAll(symptomesEntrees);

        List<Medicament> medicaments = Medicament.getMedicamentsByAge(entityManager, age);

        String fonction = "min: ";
        for (Medicament medicament : medicaments) {
            fonction += medicament.getPrix() + medicament.getNom();
            if (medicament.getId() != medicaments.get(medicaments.size() - 1).getId()) {
                fonction += " + ";
            }
        }

        System.out.println("Fonction : " + fonction);

        ArrayList<String> contrainte = new ArrayList<String>();
        contrainte.add(fonction);

        String ligneContrainte = null;
        for (Symptome symptome : symptomes) {
            ligneContrainte = "";
            for (Medicament medicament : medicaments) {
                VMedicamentSymptome tempMedicament = VMedicamentSymptome.getByIdSymptome(entityManager,
                        medicament.getId(), symptome.getId());
                int tempEffet = 0;
                if (tempMedicament != null) {
                    tempEffet = tempMedicament.getEffet();
                }
                ligneContrainte += tempEffet + medicament.getNom();
                if (medicament.getId() != medicaments.get(medicaments.size() - 1).getId()) {
                    ligneContrainte += " + ";
                }
            }
            ligneContrainte += " >= " + symptome.getEffet();

            contrainte.add(ligneContrainte);
        }

        LP lp = null;

        for (String string : contrainte) {
            System.out.println(string);
        }

        try {
            lp = new LP(contrainte);

            SolutionType solutionType = lp.resolve();

            if (solutionType == SolutionType.OPTIMUM) {
                Solution solution = lp.getSolution();
                VMedicamentSymptome tempMedicament = null;

                for (Variable variable : solution.getVariables()) {
                    VMedicamentSymptome m = VMedicamentSymptome.getByName(entityManager, variable.getName());
                    tempMedicament = new VMedicamentSymptome();

                    tempMedicament = m;
                    tempMedicament.setQuantite((int) Math.round(variable.getValue()));
                    tempMedicament.setPrixTotal(tempMedicament.getQuantite() * tempMedicament.getPrix());

                    if (tempMedicament.getQuantite() != 0) {
                        result.add(tempMedicament);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Medicament(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Medicament() {
    }

}
