package com.hopital.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.hopital.util.ConnectionPostgres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Query;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity(name = "v_medicaments_symptomes")
public class VMedicamentSymptome {
    @Id
    private int id;

    @Column(name = "id_medicament")
    private int idMedicament;

    private String nom;

    private double prix;

    @Transient
    private int idSymptome;

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
        Query query = entityManager.createNativeQuery(sql,
                VMedicamentSymptome.class);
        return query.getResultList();
    }

    public static Object get(EntityManager entityManager) {
        String sql = "select * from v_medicaments_symptomes";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

    public VMedicamentSymptome getContreIndication(EntityManager entityManager, int age) {
        String sql = """
                select *
                from v_medicaments_symptomes
                where
                    id_medicament = :id_medicament
                    and :age between age_debut and age_fin
                    and effet < 0
                """;
        Query query = entityManager.createNativeQuery(sql,
                VMedicamentSymptome.class);

        query.setParameter("id_medicament", this.getIdMedicament());
        query.setParameter("age", age);
        if (query.getResultList().size() == 0)
            return null;

        return (VMedicamentSymptome) query.getResultList().get(0);
    }
}