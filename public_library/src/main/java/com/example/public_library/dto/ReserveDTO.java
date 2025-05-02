package com.example.public_library.dto;

import java.time.LocalDateTime;

public class ReserveDTO {
    private String email;
    private String nameBook;
    private LocalDateTime reserveDate = LocalDateTime.now();
    private String status;
    public ReserveDTO(){

    }
    public ReserveDTO(String email, String nameBook, LocalDateTime reserveDate, String status) {
        this.email = email;
        this.nameBook = nameBook;
        this.reserveDate = reserveDate;
        this.status = status;
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
