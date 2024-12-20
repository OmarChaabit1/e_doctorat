package com.example.e_doctorat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.e_doctorat.models.Candidat;
import com.example.e_doctorat.services.CandidatService;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {
    @Autowired
    CandidatService candidatService;

    @GetMapping
    public ResponseEntity<List<Candidat>> getCandidats() {
        List<Candidat> candidats = candidatService.getCandidats();
        return ResponseEntity.ok(candidats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidat(@PathVariable long id) {
        Candidat candidat = candidatService.getCandidat(id);
        return ResponseEntity.ok(candidat);
    }

    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat newCandidat = candidatService.createCandidat(candidat);
        return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable long id, @RequestBody Candidat candidat) {
        Candidat updatedCandidat = candidatService.updateCandidat(id, candidat);
        return ResponseEntity.ok(updatedCandidat);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable long id) {
        candidatService.deleteCandidat(id);
        return ResponseEntity.noContent().build();
    }

}
