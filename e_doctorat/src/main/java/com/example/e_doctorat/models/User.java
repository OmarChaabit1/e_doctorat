package com.example.e_doctorat.models;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 150, nullable = false, unique = true)
    private String username;

    @Column(length = 150, nullable = false)
    private String first_name;

    @Column(length = 150, nullable = false)
    private String last_name;

    @Column(unique = true)
    private String email;

    private boolean is_superuser;

    private boolean is_staff;

    private boolean is_active;

    private Date date_joined;

    private Date last_login;
}