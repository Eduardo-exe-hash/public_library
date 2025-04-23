package com.example.public_library.repository;

import com.example.public_library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {}