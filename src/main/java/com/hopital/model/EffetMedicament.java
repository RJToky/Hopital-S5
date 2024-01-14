package com.hopital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "effets_medicaments")
public class EffetMedicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_medicament")
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "id_symptome")
    private Symptome symptome;

    @Column(name = "age_debut")
    private int ageDebut;

    @Column(name = "age_fin")
    private int ageFin;

    @Column(name = "effet")
    private int effet;
}
