package com.example.public_library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "db_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length =255,nullable = false )
    private String title;
    @Column(length = 255,nullable = false)
    private String author;
    @Column(nullable = false, unique = true)
    private int bookCod;
    @Column(nullable = false)
    private int amount;

    public Book(){

    }

    public Book(Long id, String title, String author, int bookCod, int amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.bookCod = bookCod;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookCod() {
        return bookCod;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookCod(int bookCod) {
        this.bookCod = bookCod;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
