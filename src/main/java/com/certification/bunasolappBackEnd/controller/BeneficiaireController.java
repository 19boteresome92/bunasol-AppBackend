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

import com.certification.bunasolappBackEnd.entity.Beneficiaire;
import com.certification.bunasolappBackEnd.service.BeneficiaireService;

@RestController
@RequestMapping("/api/beneficiaire")
public class BeneficiaireController {

    @Autowired
    private BeneficiaireService beneficiaireService;

    @GetMapping
    public ResponseEntity<List<Beneficiaire>> getListBeneficiaires() {
        List<Beneficiaire> beneficiaires = beneficiaireService.getListBeneficiaires();
        return new ResponseEntity<>(beneficiaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiaire> getBeneficiaireById(@PathVariable Long id) {
        Optional<Beneficiaire> beneficiaire = beneficiaireService.getBeneficiaireById(id);
        return beneficiaire.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Beneficiaire> createBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        Beneficiaire savedBeneficiaire = beneficiaireService.createBeneficiaire(beneficiaire);
        return new ResponseEntity<>(savedBeneficiaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiaire> updateBeneficiaire(@PathVariable Long id,
            @RequestBody Beneficiaire updatedAgent) {
        Beneficiaire beneficiaire = beneficiaireService.updateBeneficiaire(id, updatedAgent);
        return new ResponseEntity<>(beneficiaire, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiaire(@PathVariable Long id) {
        beneficiaireService.deleteBeneficiaire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
