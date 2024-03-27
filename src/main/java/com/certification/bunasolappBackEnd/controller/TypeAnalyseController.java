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

import com.certification.bunasolappBackEnd.entity.TypeAnalyse;
import com.certification.bunasolappBackEnd.service.TypeAnalyseService;

@RestController
@RequestMapping("/api/types-analyses")
public class TypeAnalyseController {

    @Autowired
    private TypeAnalyseService typeAnalyseService;

    @GetMapping
    public ResponseEntity<List<TypeAnalyse>> getListTypeAnalyses() {
        List<TypeAnalyse> typeAnalyses = typeAnalyseService.getListTypeAnalyses();
        return new ResponseEntity<>(typeAnalyses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeAnalyse> getTypeAnalyseById(@PathVariable Long id) {
        Optional<TypeAnalyse> typeAnalyse = typeAnalyseService.getTypeAnalyseById(id);
        return typeAnalyse.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TypeAnalyse> createTypeAnalyse(@RequestBody TypeAnalyse typeAnalyse) {
        TypeAnalyse savedTypeAnalyse = typeAnalyseService.createTypeAnalyse(typeAnalyse);
        return new ResponseEntity<>(savedTypeAnalyse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeAnalyse> updateTypeAnalyse(@PathVariable Long id,
            @RequestBody TypeAnalyse updateResultatAnalyse) {
        TypeAnalyse typeAnalyse = typeAnalyseService.updateTypeAnalyse(id, updateResultatAnalyse);
        return new ResponseEntity<>(typeAnalyse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeAnalys(@PathVariable Long id) {
        typeAnalyseService.deleteTypeAnalyse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
