package com.hopital.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    public static ArrayList<VMedicamentSymptome> connaitreMedicamentsMoinsCher(EntityManager entityManager,
            ArrayList<Symptome> symptomesEntrees, int age) throws Exception {
        ArrayList<Symptome> symptomes = new ArrayList<Symptome>();
        symptomes.addAll(symptomesEntrees);
        ArrayList<VMedicamentSymptome> medicaments = new ArrayList<VMedicamentSymptome>();

        for (int i = 0; i < symptomes.size(); i++) {
            List<VMedicamentSymptome> medicamentsCorrespondants = symptomes.get(i).getMedicamentsCorrespondants(
                    entityManager,
                    age);
            if (medicamentsCorrespondants.size() != 0) {
                VMedicamentSymptome medicamentMoinsCher = new VMedicamentSymptome();
                medicamentMoinsCher.setSymptome(symptomes.get(i));
                medicamentMoinsCher.setPrixTotal(Double.MAX_VALUE);

                for (VMedicamentSymptome medicamentCorrespondant : medicamentsCorrespondants) {
                    int quantite = (int) Math
                            .ceil((double) symptomes.get(i).getEffet() / (double) medicamentCorrespondant.getEffet());
                    double prixTotal = quantite * medicamentCorrespondant.getPrix();

                    if (prixTotal < medicamentMoinsCher.getPrixTotal()) {
                        medicamentMoinsCher.setIdMedicament(medicamentCorrespondant.getIdMedicament());
                        medicamentMoinsCher.setNom(medicamentCorrespondant.getNom());
                        medicamentMoinsCher.setPrix(medicamentCorrespondant.getPrix());
                        medicamentMoinsCher.setEffet(medicamentCorrespondant.getEffet());
                        medicamentMoinsCher.setAgeDebut(medicamentCorrespondant.getAgeDebut());
                        medicamentMoinsCher.setAgeFin(medicamentCorrespondant.getAgeFin());
                        medicamentMoinsCher.setQuantite(quantite);
                        medicamentMoinsCher.setPrixTotal(quantite * medicamentCorrespondant.getPrix());
                    }
                }
                medicaments.add(medicamentMoinsCher);

                VMedicamentSymptome contreIndication = medicamentMoinsCher.getContreIndication(entityManager, age);

                if (contreIndication != null) {
                    Symptome symptomeIndication = contreIndication.getSymptome();
                    symptomeIndication.setEffet(-1 * contreIndication.getEffet() *
                            medicamentMoinsCher.getQuantite());

                    Symptome newInstance = new Symptome();
                    newInstance.setId(symptomeIndication.getId());
                    newInstance.setNom(symptomeIndication.getNom());
                    newInstance.setEffet(symptomeIndication.getEffet());
                    symptomes.add(newInstance);
                }
            }
        }
        return medicaments;
    }

    public Medicament(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Medicament() {
    }

}
