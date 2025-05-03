package com.example.public_library.dto;

import java.util.Objects;

public class IsbnLowDTO {
    private Long id;
    private String number;

    public IsbnLowDTO() {}

    public IsbnLowDTO(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IsbnLowDTO)) return false;
        IsbnLowDTO isbn = (IsbnLowDTO) o;
        return Objects.equals(id, isbn.id) &&
                Objects.equals(number, isbn.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "IsbnLowDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
