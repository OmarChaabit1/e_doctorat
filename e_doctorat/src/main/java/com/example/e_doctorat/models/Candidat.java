package com.example.e_doctorat.models;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Data
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Column(length = 30, nullable = false)
    private String cne;

    @Column(length = 30, nullable = false)
    private String cin;

    @Column(nullable = false)
    private String nomCandidatAr;

    @Column(nullable = false)
    private String prenomCandidatAr;

    @Lob
    @Column(nullable = false)
    private String adresse;

    @Lob
    @Column(nullable = false)
    private String adresseAr;

    @Column(length = 20, nullable = false)
    private String sexe;

    @Column(nullable = false)
    private String villeDeNaissance;

    @Column(nullable = false)
    private String villeDeNaissanceAr;

    @Column(nullable = true)
    private String ville;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;

    @Column(length = 30, nullable = true)
    private String typeDeHandiCape;

    @Column(nullable = true)
    private String academie;

    @Column(length = 30, nullable = true)
    private String telCandidat;

    @Column(length = 100, nullable = true)
    private String pathCv;

    @Column(length = 100, nullable = true)
    private String pathPhoto;

    @Column(nullable = true)
    private Integer etatDossier;

    @Column(length = 50, nullable = true)
    private String situation_familiale;

    @Column(nullable = true)
    private Integer paysId;


    @Column(nullable = true)
    private Boolean fonctionaire;

    @OneToOne
    private User user_id;
}
