package com.example.public_library.repository;

import com.example.public_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String title);
    Optional<Book> findAuthor(String author);
}
