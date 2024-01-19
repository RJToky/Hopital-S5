package com.hopital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maladies_symptomes")
public class MaladieSymptome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_maladie")
    private Maladie maladie;

    @OneToOne
    @JoinColumn(name = "id_symptome")
    private Symptome symptome;

    @Column(name = "age_debut")
    private int ageDebut;

    @Column(name = "age_fin")
    private int ageFin;

    @Column(name = "effet_min")
    private int effetMin;

    @Column(name = "effet_max")
    private int effetMax;
}
