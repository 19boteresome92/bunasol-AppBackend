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

import com.certification.bunasolappBackEnd.entity.TypeEchantillon;
import com.certification.bunasolappBackEnd.service.TypeEchantillonService;

@RestController
@RequestMapping("/api/types-echantillons")
public class TypeEchantillonController {

    @Autowired
    private TypeEchantillonService typeEchantillonService;

    @GetMapping
    public ResponseEntity<List<TypeEchantillon>> getListTypeEchantillons() {
        List<TypeEchantillon> TypeEchantillons = typeEchantillonService.getListTypeEchantillons();
        return new ResponseEntity<>(TypeEchantillons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEchantillon> getTypeEchantillonById(@PathVariable Long id) {
        Optional<TypeEchantillon> typeEchantillon = typeEchantillonService.getTypeEchantillonById(id);
        return typeEchantillon.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TypeEchantillon> createTypeEchantillon(@RequestBody TypeEchantillon typeEchantillon) {
        TypeEchantillon savedTypeEchantillon = typeEchantillonService.createTypeEchantillon(typeEchantillon);
        return new ResponseEntity<>(savedTypeEchantillon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeEchantillon> updateTypeEchantillon(@PathVariable Long id,
            @RequestBody TypeEchantillon updateResultatAnalyse) {
        TypeEchantillon typeEchantillon = typeEchantillonService.updateTypeEchantillon(id, updateResultatAnalyse);
        return new ResponseEntity<>(typeEchantillon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeEchantillon(@PathVariable Long id) {
        typeEchantillonService.deleteTypeEchantillon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
