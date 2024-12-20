package com.example.e_doctorat.repositories;

import com.example.e_doctorat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
