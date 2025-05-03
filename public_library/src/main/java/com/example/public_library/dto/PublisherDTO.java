package com.example.public_library.dto;

import java.util.Objects;

public class PublisherDTO {
    private Long id;
    private String name;
    private String city;
    private String country;
    private String email;

    public PublisherDTO() {}

    public PublisherDTO(Long id, String name, String city, String country, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublisherDTO)) return false;
        PublisherDTO publisher = (PublisherDTO) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(city, publisher.city) &&
                Objects.equals(country, publisher.country) &&
                Objects.equals(email, publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, country, email);
    }

    @Override
    public String toString() {
        return "PublisherDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
