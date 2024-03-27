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

import com.certification.bunasolappBackEnd.entity.Echantillon;
import com.certification.bunasolappBackEnd.service.EchantillonService;

@RestController
@RequestMapping("/api/echantillons")
public class EchantillonController {

    @Autowired
    private EchantillonService echantillonService;

    @GetMapping
    public ResponseEntity<List<Echantillon>> getListEchantillons() {
        List<Echantillon> echantillons = echantillonService.getListEchantillons();
        return new ResponseEntity<>(echantillons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Echantillon> getEchantillonById(@PathVariable Long id) {
        Optional<Echantillon> echantillon = echantillonService.getEchantillonById(id);
        return echantillon.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Echantillon> createEchantillon(@RequestBody Echantillon echantillon) {
        Echantillon savedAgent = echantillonService.createEchantillon(echantillon);
        return new ResponseEntity<>(savedAgent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Echantillon> updateEchantillon(@PathVariable Long id, @RequestBody Echantillon updatedAgent) {
        Echantillon echantillon = echantillonService.updateEchantillon(id, updatedAgent);
        return new ResponseEntity<>(echantillon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEchantillon(@PathVariable Long id) {
        echantillonService.deleteEchantillon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
