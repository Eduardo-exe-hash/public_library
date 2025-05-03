package com.example.public_library.dto;

import java.io.Serial;

public class MessageDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private String key;

    public MessageDTO(String message, String key) {
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
