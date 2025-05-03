package com.example.public_library.dto;

import java.util.Objects;

public class AuthorDTO {
    private Long id;
    private String name;
    private String nationality;
    private String biography;
    private String email;

    public AuthorDTO() {}

    public AuthorDTO(Long id, String name, String nationality, String biography, String email) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.biography = biography;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBiography() {
        return biography;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDTO)) return false;
        AuthorDTO author = (AuthorDTO) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(name, author.name) &&
                Objects.equals(nationality, author.nationality) &&
                Objects.equals(biography, author.biography) &&
                Objects.equals(email, author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nationality, biography, email);
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", biography='" + biography + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
