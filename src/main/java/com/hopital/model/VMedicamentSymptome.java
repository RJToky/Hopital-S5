package com.hopital.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "v_medicaments_symptomes")
public class VMedicamentSymptome {
    @Id
    private int id;

    private String nom;
    private double prix;

    @OneToOne
    @JoinColumn(name = "id_symptome")
    private Symptome symptome;

    @Column(name = "age_debut")
    private int ageDebut;

    @Column(name = "age_fin")
    private int ageFin;

    private int effet;

    @Transient
    private int quantite;

    @Transient
    private double prixTotal;

    public static List<VMedicamentSymptome> getAll(EntityManager entityManager) {
        String sql = "select * from v_medicaments_symptomes";
        Query query = entityManager.createNativeQuery(sql, VMedicamentSymptome.class);
        return query.getResultList();
    }
}
