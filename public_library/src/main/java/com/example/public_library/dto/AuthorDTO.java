package com.example.public_library;

import java.util.Objects;

public class AuthorDTO {
    private Long id;
    private String name;
    private String nationality;
    private String biography;
    private String email;

    public Author() {}

    public Author(Long id, String name, String nationality, String biography, String email) {
        this.id = id;
        this.nome = name;
        this.nationality = nationality;
        this.biografia = biography;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
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
        if (!(o instanceof AuthorDTO author)) return false;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(email, author.email) && Objects.equals(nationality, author.nationality) && Objects.equals(biography, author.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, nationality, biography);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", biography='" + biography + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
