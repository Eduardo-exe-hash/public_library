package com.example.public_library.service;

import com.example.public_library.model.Book;
import com.example.public_library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book findByTitle(String title){
        return bookRepository.findByName(title).orElse(null);
    }
    public Book findAuthor(String author){
        return bookRepository.findAuthor(author).orElse(null);
    }
}
