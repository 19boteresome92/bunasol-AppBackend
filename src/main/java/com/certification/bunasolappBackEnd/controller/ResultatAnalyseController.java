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

import com.certification.bunasolappBackEnd.entity.ResultatAnalyse;
import com.certification.bunasolappBackEnd.service.ResultatAnalyseService;

@RestController
@RequestMapping("/api/resultats-analyses")
public class ResultatAnalyseController {

    @Autowired
    private ResultatAnalyseService resultatAnalyseService;

    @GetMapping
    public ResponseEntity<List<ResultatAnalyse>> getListResultatsAnalyses() {
        List<ResultatAnalyse> resultatAnalyses = resultatAnalyseService.getListResultatsAnalyses();
        return new ResponseEntity<>(resultatAnalyses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultatAnalyse> getResultatById(@PathVariable Long id) {
        Optional<ResultatAnalyse> resultatAnalyse = resultatAnalyseService.getResultatById(id);
        return resultatAnalyse.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ResultatAnalyse> createResultatAnalyse(@RequestBody ResultatAnalyse resultatAnalyse) {
        ResultatAnalyse savedResultatAnalyse = resultatAnalyseService.createResultatAnalyse(resultatAnalyse);
        return new ResponseEntity<>(savedResultatAnalyse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultatAnalyse> updateResultatAnalyse(@PathVariable Long id,
            @RequestBody ResultatAnalyse updateResultatAnalyse) {
        ResultatAnalyse resultatAnalyse = resultatAnalyseService.updateResultatAnalyse(id, updateResultatAnalyse);
        return new ResponseEntity<>(resultatAnalyse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultatAnalyse(@PathVariable Long id) {
        resultatAnalyseService.deleteResultatAnalyse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
