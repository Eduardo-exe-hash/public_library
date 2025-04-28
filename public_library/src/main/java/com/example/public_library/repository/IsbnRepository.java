package com.example.public_library.repository;

import com.seu.pacote.model.Isbn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsbnRepository extends JpaRepository<Isbn, Long> {}
