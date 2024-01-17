package com.hopital.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "maladies")
public class Maladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "maladie")
    private List<MaladieSymptome> maladiesSymptomes;

    @Transient
    private double probabilite;

    public static ArrayList<Maladie> connaitreMaladie(EntityManager entityManager, ArrayList<Symptome> symptomes,
            int age) {
        ArrayList<Maladie> maladies = new ArrayList<Maladie>();

        Set<Maladie> maladiesPossibles = new HashSet<Maladie>();
        for (Symptome symptome : symptomes) {
            maladiesPossibles.addAll(symptome.getMaladiesPossibles(entityManager, age));
        }

        for (Maladie maladie : maladiesPossibles) {
            int nombreSymptomesEgaux = 0;
            for (Symptome symptome : symptomes) {
                for (MaladieSymptome maladieSymptome : maladie.getMaladiesSymptomes()) {
                    if (maladieSymptome.getSymptome().getId() == symptome.getId() && isBetween(symptome.getEffet(),
                            maladieSymptome.getEffetMin(), maladieSymptome.getEffetMax())
                            && isBetween(age, maladieSymptome.getAgeDebut(), maladieSymptome.getAgeFin())) {
                        nombreSymptomesEgaux++;
                    }
                }
            }
            maladie.setProbabilite((double) (nombreSymptomesEgaux * 100) / maladie.getMaladiesSymptomes().size());
            maladies.add(maladie);
        }

        // Trier par probabitlite
        maladies.sort((Maladie m1, Maladie m2) -> Double.compare(m2.getProbabilite(), m1.getProbabilite()));

        return maladies;
    }

    public ArrayList<MedicamentQuantite> getMedicamentsMoinsCher(EntityManager entityManager, int age) {
        ArrayList<MedicamentQuantite> medicaments = new ArrayList<MedicamentQuantite>();
        // for (MaladieSymptome maladieSymptome : this.getMaladiesSymptomes()) {
        // medicaments.addAll(maladieSymptome.getMedicaments(entityManager));
        // }
        return medicaments;
    }

    public static boolean isBetween(int x, int min, int max) {
        return x >= min && x <= max;
    }

    public static List<Maladie> getAll(EntityManager entityManager) {
        String sql = "select * from maladies";
        Query query = entityManager.createNativeQuery(sql, Maladie.class);
        return query.getResultList();
    }

}
