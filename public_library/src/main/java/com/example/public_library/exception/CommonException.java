package com.example.public_library.exception;

import com.example.public_library.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serial;

public class CommonException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    protected HttpStatus status;
    protected String key;
    protected String text;

    public CommonException(HttpStatus status, String key, String text) {
        this.status = status;
        this.key = key;
        this.text = text;
    }

    public ResponseEntity<MessageDTO> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDTO(text, key));
    }
}
