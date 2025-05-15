package com.example.public_library.controller;
import com.example.public_library.dto.*;
import com.example.public_library.model.Book;
import com.example.public_library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Register a new book", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Book registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
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
    @Operation(summary = "Find book by ID", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book found"),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return service.findById(id);
    }
    @Operation(summary = "Find book by title", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book found"),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/buscar")
    public Book findByTitle(@RequestParam String title){
        return service.findByTitle(title);
    }
    @Operation(summary = "Find books by author", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of books by author returned"),
            @ApiResponse(responseCode = "404", description = "Author not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/busca-autor")
    public List<Book> findAuthor(@RequestParam String author){
        return service.findByAuthor(author);
    }
    @Operation(summary = "Get a list of all books (basic info)", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of books returned")
    })
    @GetMapping
    public List<BookLowDTO> listAllow(){
        return service.listAllow();
    }
    @Operation(summary = "Update book data", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping("/{id}")
    public BookLowDTO update(@RequestBody BookDTO book){
        return service.update(book);
    }
    @Operation(summary = "Delete book by ID", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
