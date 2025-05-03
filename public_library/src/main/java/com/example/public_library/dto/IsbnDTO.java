package com.example.public_library.dto;

import java.util.Objects;

public class IsbnDTO {
    private Long id;
    private String number;
    private String edition;
    private Integer yearPublication;
    private Long publisherId;

    public IsbnDTO() {}

    public IsbnDTO(Long id, String number, String edition, Integer yearPublication, Long publisherId) {
        this.id = id;
        this.number = number;
        this.edition = edition;
        this.yearPublication = yearPublication;
        this.publisherId = publisherId;
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

    public Long getPublisherId() {
        return publisherId;
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

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IsbnDTO)) return false;
        IsbnDTO isbn = (IsbnDTO) o;
        return Objects.equals(id, isbn.id) &&
                Objects.equals(number, isbn.number) &&
                Objects.equals(edition, isbn.edition) &&
                Objects.equals(yearPublication, isbn.yearPublication) &&
                Objects.equals(publisherId, isbn.publisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, edition, yearPublication, publisherId);
    }

    @Override
    public String toString() {
        return "IsbnDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", edition='" + edition + '\'' +
                ", yearPublication=" + yearPublication +
                ", publisherId=" + publisherId +
                '}';
    }
}
