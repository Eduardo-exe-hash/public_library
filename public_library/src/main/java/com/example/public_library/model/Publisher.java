package com.example.public_library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "db_publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;

    private String country;

    @Column(nullable = false, unique = true)
    private String email;

    public Publisher() {}

    public Publisher(Long id, String name, String city, String country, String email) {
            this.id = id;
            this.name = name;
            this.city = city;
            this.country = country;
            this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
}
