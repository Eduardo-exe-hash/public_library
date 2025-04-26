package com.example.public_library.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String nameBook;
    @Column(nullable = false)
    private LocalDateTime reserveDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String status;
    public Reserve(){

    }
    public Reserve(int id, String email, String nameBook,LocalDateTime reserveDate, String status) {
        this.id = id;
        this.email = email;
        this.nameBook = nameBook;
        this.reserveDate = reserveDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public LocalDateTime getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDateTime reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
