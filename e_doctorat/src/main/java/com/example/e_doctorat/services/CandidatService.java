package com.example.e_doctorat.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_doctorat.models.Candidat;
import com.example.e_doctorat.repositories.CandidatRepository;

@Service
public class CandidatService {
    @Autowired
    CandidatRepository candidatRepository;

    public List<Candidat> getCandidats() {
        return candidatRepository.findAll();
    }

    public Candidat getCandidat(long id) {
        return candidatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candidat not found with id: " + id));
    }

    public Candidat createCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public Candidat updateCandidat(long id, Candidat candidat) {
        Candidat existingCandidat = candidatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candidat not found with id: " + id));

        Field[] fields = Candidat.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if ("id".equals(field.getName())) {
                continue;
            }

            try {
                Object newValue = field.get(candidat);
                if (newValue != null) {
                    field.set(existingCandidat, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return candidatRepository.save(existingCandidat);
    }

    public void deleteCandidat(long id) {
        Candidat candidat = candidatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candidat not found with id: " + id));

        candidatRepository.delete(candidat);
    }
}
