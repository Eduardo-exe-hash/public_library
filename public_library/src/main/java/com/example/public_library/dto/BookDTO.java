package com.example.public_library.dto;
public class BookDTO {
    private Long id;
    private int bookCod;
    private String title;
    private String author;
    private int amount;
    public BookDTO(){

    }
    public BookDTO(int bookCod, String title, String author, int amount, Long id) {
        this.bookCod = bookCod;
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.id = id;
    }

    public int getBookCod() {
        return bookCod;
    }

    public void setBookCod(int bookCod) {
        this.bookCod = bookCod;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
