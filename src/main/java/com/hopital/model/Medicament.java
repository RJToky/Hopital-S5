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
            ArrayList<Symptome> symptomes, int age) {
        ArrayList<VMedicamentSymptome> medicaments = new ArrayList<VMedicamentSymptome>();

        for (Symptome symptome : symptomes) {
            List<VMedicamentSymptome> medicamentsCorrespondants = symptome.getMedicamentsCorrespondants(entityManager,
                    age);
            VMedicamentSymptome medicamentMoinsCher = new VMedicamentSymptome();
            medicamentMoinsCher.setSymptome(symptome);
            medicamentMoinsCher.setPrixTotal(Double.MAX_VALUE);

            for (VMedicamentSymptome medicamentCorrespondant : medicamentsCorrespondants) {
                int quantite = (int) Math
                        .ceil((double) symptome.getEffet() / (double) medicamentCorrespondant.getEffet());
                double prixTotal = quantite * medicamentCorrespondant.getPrix();

                if (prixTotal < medicamentMoinsCher.getPrixTotal()) {
                    medicamentMoinsCher.setId(medicamentCorrespondant.getId());
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
