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

import com.certification.bunasolappBackEnd.entity.Laboratoire;
import com.certification.bunasolappBackEnd.service.LaboratoireService;

@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {

    @Autowired
    private LaboratoireService laboratoireService;

    @GetMapping
    public ResponseEntity<List<Laboratoire>> getListLaboratoires() {
        List<Laboratoire> laboratoires = laboratoireService.getListLaboratoires();
        return new ResponseEntity<>(laboratoires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable Long id) {
        Optional<Laboratoire> laboratoire = laboratoireService.getLaboratoireById(id);
        return laboratoire.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Laboratoire> createLaboratoire(@RequestBody Laboratoire laboratoire) {
        Laboratoire savedLaboratoire = laboratoireService.createLaboratoire(laboratoire);
        return new ResponseEntity<>(savedLaboratoire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratoire> updateLaboratoire(@PathVariable Long id,
            @RequestBody Laboratoire updatedAgent) {
        Laboratoire laboratoire = laboratoireService.updateLaboratoire(id, updatedAgent);
        return new ResponseEntity<>(laboratoire, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratoire(@PathVariable Long id) {
        laboratoireService.deleteLaboratoire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
