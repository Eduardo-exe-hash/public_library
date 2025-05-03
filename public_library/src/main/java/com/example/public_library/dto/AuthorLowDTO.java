package com.example.public_library.dto;

import java.util.Objects;

public class AuthorLowDTO {
    private Long id;
    private String name;

    public AuthorLowDTO() {}

    public AuthorLowDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorLowDTO)) return false;
        AuthorLowDTO author = (AuthorLowDTO) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AuthorLowDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
