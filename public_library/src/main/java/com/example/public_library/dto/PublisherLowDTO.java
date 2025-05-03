package com.example.public_library.dto;

import java.util.Objects;

public class PublisherLowDTO {
    private Long id;
    private String name;

    public PublisherLowDTO() {}

    public PublisherLowDTO(Long id, String name) {
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
        if (!(o instanceof PublisherLowDTO)) return false;
        PublisherLowDTO publisher = (PublisherLowDTO) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "PublisherLowDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
