package com.example.public_library.repository;

import com.example.public_library.model.Isbn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IsbnRepository extends JpaRepository<Isbn, Long> {
    List<Isbn> findByNumberContainingIgnoreCase(String number);
}
