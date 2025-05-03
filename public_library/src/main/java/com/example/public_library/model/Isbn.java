package com.example.public_library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "db_isbn")
public class Isbn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    private String edition;

    private Integer yearPublication;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Isbn() {}

    public Isbn(Long id, String number, String edition, Integer yearPublication, Publisher publisher) {
        this.id = id;
        this.number = number;
        this.edition = edition;
        this.yearPublication = yearPublication;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getEdition() {
        return edition;
    }

    public Integer getYearPublication() {
        return yearPublication;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setYearPublication(Integer yearPublication) {
        this.yearPublication = yearPublication;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
