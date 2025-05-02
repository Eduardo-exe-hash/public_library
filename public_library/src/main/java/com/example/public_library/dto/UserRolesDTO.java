package com.example.public_library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRolesDTO {
    private Long id;

    @JsonProperty("name")
    private String name;
    private String email;
    private String[] roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
