package com.example.e_doctorat.repositories;

import com.example.e_doctorat.models.Candidat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
