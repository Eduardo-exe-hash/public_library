package com.example.public_library.dto;
public class BookDTO {
    private int bookCod;
    private String title;
    private String author;
    private String amount;
    public BookDTO(){

    }
    public BookDTO(int bookCod, String title, String author, String amount) {
        this.bookCod = bookCod;
        this.title = title;
        this.author = author;
        this.amount = amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
