package com.hopital.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "symptomes")
public class Symptome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @JsonIgnore
    @Transient
    private int effet;

    public List<Maladie> getMaladiesPossibles(EntityManager entityManager, int age) {
        String sql = """
                    select m.*
                    from maladies_symptomes ms
                    join maladies m on m.id = ms.id_maladie
                    where
                        ms.id_symptome = :id_symptome
                        and :age between ms.age_debut and ms.age_fin
                        and :effet between ms.effet_min and ms.effet_max
                """;
        Query query = entityManager.createNativeQuery(sql, Maladie.class);
        query.setParameter("id_symptome", this.getId());
        query.setParameter("age", age);
        query.setParameter("effet", this.getEffet());

        return query.getResultList();
    }

    public static List<Symptome> getAll(EntityManager entityManager) {
        String sql = "select * from symptomes";
        Query query = entityManager.createNativeQuery(sql, Symptome.class);
        return query.getResultList();
    }

    public static Symptome getById(EntityManager entityManager, int id) {
        String sql = "select * from symptomes where id = :id";
        Query query = entityManager.createNativeQuery(sql, Symptome.class);
        query.setParameter("id", id);
        return (Symptome) query.getSingleResult();
    }

}
