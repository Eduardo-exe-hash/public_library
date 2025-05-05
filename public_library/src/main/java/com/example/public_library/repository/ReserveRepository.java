package com.example.public_library.repository;

import com.example.public_library.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve,Long> {
    Optional<Reserve>findByNameBook(String namebook);
}