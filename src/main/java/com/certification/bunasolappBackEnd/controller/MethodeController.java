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

import com.certification.bunasolappBackEnd.entity.Methode;
import com.certification.bunasolappBackEnd.service.MethodeService;

@RestController
@RequestMapping("/api/methodes")
public class MethodeController {

    @Autowired
    private MethodeService methodeService;

    @GetMapping
    public ResponseEntity<List<Methode>> getListMethodes() {
        List<Methode> methodes = methodeService.getListMethodes();
        return new ResponseEntity<>(methodes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Methode> getMethodeById(@PathVariable Long id) {
        Optional<Methode> methode = methodeService.getMethodeById(id);
        return methode.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Methode> createMethode(@RequestBody Methode methode) {
        Methode savedMethode = methodeService.createMethode(methode);
        return new ResponseEntity<>(savedMethode, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Methode> updateMethode(@PathVariable Long id, @RequestBody Methode updatedAgent) {
        Methode methode = methodeService.updateMethode(id, updatedAgent);
        return new ResponseEntity<>(methode, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethode(@PathVariable Long id) {
        methodeService.deleteMethode(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
