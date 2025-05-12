package com.example.public_library.service;
import com.example.public_library.dto.BookLowDTO;
import com.example.public_library.model.Book;
import com.example.public_library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return bookRepository.findByTitle(title).orElse(null);
    }
    public Book findByAuthor(String author){
        return bookRepository.findByAuthor(author).orElse(null);
    }
    public List<Book> listAll(){
        return bookRepository.findAll();
    }

    public List<BookLowDTO>listAllow(){
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            BookLowDTO dto = new BookLowDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            return dto;
        }).collect(Collectors.toList());
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}
