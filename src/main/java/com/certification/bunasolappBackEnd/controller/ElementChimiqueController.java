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

import com.certification.bunasolappBackEnd.entity.ElementChimique;
import com.certification.bunasolappBackEnd.service.ElementChimiqueService;

@RestController
@RequestMapping("/api/elements-chimiques")
public class ElementChimiqueController {

    @Autowired
    private ElementChimiqueService elementChimiqueService;

    @GetMapping
    public ResponseEntity<List<ElementChimique>> getLisElementsChimiques() {
        List<ElementChimique> elementChimiques = elementChimiqueService.getLisElementsChimiques();
        return new ResponseEntity<>(elementChimiques, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElementChimique> getElementChimiqueById(@PathVariable Long id) {
        Optional<ElementChimique> elementChimique = elementChimiqueService.getElementChimiqueById(id);
        return elementChimique.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ElementChimique> createElement(@RequestBody ElementChimique elementChimique) {
        ElementChimique savedElementChimique = elementChimiqueService.createElement(elementChimique);
        return new ResponseEntity<>(savedElementChimique, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElementChimique> updateElementChimique(@PathVariable Long id,
            @RequestBody ElementChimique updatedAgent) {
        ElementChimique elementChimique = elementChimiqueService.updateElementChimique(id, updatedAgent);
        return new ResponseEntity<>(elementChimique, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementChimique(@PathVariable Long id) {
        elementChimiqueService.deleteElementChimique(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
