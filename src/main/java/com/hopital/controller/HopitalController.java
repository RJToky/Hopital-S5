package com.hopital.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hopital.model.Maladie;
import com.hopital.model.Medicament;
import com.hopital.model.Symptome;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("/hopital")
public class HopitalController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("symptomes", Symptome.getAll(entityManager));
        modelAndView.setViewName("pages/index");
        return modelAndView;
    }

    @GetMapping("/resultat")
    public ModelAndView resultat(ModelAndView modelAndView,
            @RequestParam("age") int age, @RequestParam("id_symptome") String[] listIdSymptome,
            @RequestParam("effet") String[] effets) throws Exception {
        ArrayList<Symptome> symptomes = new ArrayList<Symptome>();
        for (int i = 0; i < listIdSymptome.length; i++) {
            try {
                int idSymptome = Integer.parseInt(listIdSymptome[i]);
                int effet = Integer.parseInt(effets[i]);

                Symptome symptome = Symptome.getById(entityManager, idSymptome);
                symptome.setEffet(effet);
                symptomes.add(symptome);
            } catch (Exception e) {
            }
        }
        modelAndView.setViewName("pages/resultat");
        modelAndView.addObject("age", age);
        modelAndView.addObject("symptomes", symptomes);
        modelAndView.addObject("maladies", Maladie.connaitreMaladie(entityManager,
                symptomes, age));
        modelAndView.addObject("medicaments", Medicament.connaitreMedicamentsMoinsCher(entityManager, symptomes, age));
        return modelAndView;
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
        return ResponseEntity.ok().body(Maladie.connaitreMaladie(entityManager,
                symptomes, age));
    }

    @GetMapping("/connaitre-medicament")
    public ResponseEntity<?> vMedicamentsSymptomes(@RequestParam("id_symptome") int[] listIdSymptome,
            @RequestParam("effet") int[] effets, @RequestParam("age") int age) throws Exception {
        ArrayList<Symptome> symptomes = new ArrayList<Symptome>();
        for (int i = 0; i < listIdSymptome.length; i++) {
            Symptome symptome = new Symptome();
            symptome.setId(listIdSymptome[i]);
            symptome.setEffet(effets[i]);
            symptomes.add(symptome);
        }
        return ResponseEntity.ok().body(Medicament.connaitreMedicamentsMoinsCher(entityManager, symptomes, age));
    }

}
