package com.hopital.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hopital.model.Maladie;
import com.hopital.model.Symptome;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("/")
public class HopitalController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public String index() {
        return "pages/index";
    }

    @GetMapping("/connaitre-maladie")
    public ResponseEntity<?> connaitreMaladie(@RequestParam("id_symptome") int[] listIdSymptome,
            @RequestParam("effet") int[] effets, @RequestParam("age") int age) {
        ArrayList<Symptome> symptomes = new ArrayList<Symptome>();
        for (int i = 0; i < listIdSymptome.length; i++) {
            Symptome symptome = new Symptome();
            symptome.setId(listIdSymptome[i]);
            symptome.setEffet(effets[i]);
            symptomes.add(symptome);
        }
        return ResponseEntity.ok().body(Maladie.connaitreMaladie(entityManager, symptomes, age));
    }

    @GetMapping("/maladies")
    public ResponseEntity<?> maladies() {
        return ResponseEntity.ok().body(Maladie.getAll(entityManager));
    }
}
