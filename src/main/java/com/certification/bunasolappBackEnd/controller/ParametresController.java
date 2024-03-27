package com.certification.bunasolappBackEnd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certification.bunasolappBackEnd.entity.Parametres;
import com.certification.bunasolappBackEnd.service.ParametresService;

@RestController
@RequestMapping("/api/parametres")
public class ParametresController {

    @Autowired
    private ParametresService parametreService;

    @GetMapping
    public ResponseEntity<List<Parametres>> getListParametres() {
        List<Parametres> parametres = parametreService.getListParametres();
        return new ResponseEntity<>(parametres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parametres> getParametreById(@PathVariable Long id) {
        Optional<Parametres> parametre = parametreService.getParametreById(id);
        return parametre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Parametres> createParametres(@RequestBody Parametres parametre) {
        Parametres savedParametre = parametreService.createParametres(parametre);
        return new ResponseEntity<>(savedParametre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parametres> updateParametres(@PathVariable Long id, @RequestBody Parametres updatedAgent) {
        Parametres parametre = parametreService.updateParametres(id, updatedAgent);
        return new ResponseEntity<>(parametre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParametre(@PathVariable Long id) {
        parametreService.deleteParametre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
