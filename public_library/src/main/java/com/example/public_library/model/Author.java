package com.example.public_library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "db_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    private String nationality;
    private String biography;
    @Column(unique = true)
    private String email;

    public Author() {}

    public Author(Long id, String name, String nationality, String biography, String email) {
        this.id = id;
        this.name = name;
        this.nationality= nationality;
        this.biography = biography;
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
}
