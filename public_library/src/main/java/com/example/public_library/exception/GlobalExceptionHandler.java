package com.example.public_library.exception;

import com.example.public_library.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CommonException.class)
    protected ResponseEntity<MessageDTO> handleCommonsException(CommonException exception) {
        logger.error("[exception] " + exception);
        return exception.getMessageError();
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<MessageDTO> handleException(Exception ex) {
        logger.error("Unhandled exception: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageDTO("Unhandled exception: " + ex.toString(),
                        "public_library.exception"));
    }
}
