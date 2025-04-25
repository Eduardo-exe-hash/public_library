package com.example.public_library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "db_isbn")
public class Isbn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String edition;

    private Integer yearPublication;

  public User(){}
  
  public User(Long id, String number, String edition, String yearPublication) {
      this.id = id;
      this.number = number;
      this.eddition = edition;
      this.yearPublication = yearPublication;
    }

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getNumber() {
      return number;
  }

  public void setNumber(String number) {
      this.number = number;
  }

  public String getEdition() {
      return edition;
  }

  public void setEdition(String edition) {
      this.edition = edition;
  }

  public String getYearPublication() {
      return yearPublication;
  }

  public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }
}
