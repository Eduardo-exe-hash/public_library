package com.example.public_library.controller;
import com.example.public_library.dto.BookDTO;
import com.example.public_library.dto.BookLowDTO;
import com.example.public_library.model.Book;
import com.example.public_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService service;
    @PostMapping
    public ResponseEntity<Book> cadlivro(@RequestBody BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setAmount(book.getAmount());
        book.setBookCod(bookDTO.getBookCod());
        Book newBook = service.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/buscar")
    public Book findByTitle(@RequestParam String title){
        return service.findByTitle(title);
    }
    @GetMapping("/busca-autor")
    public Book findAuthor(@RequestParam String author){
        return service.findByAuthor(author);
    }
    @GetMapping
    public List<BookLowDTO> listAllow(){
        return service.listAllow();
    }
}
