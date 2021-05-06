package com.library.libraryproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShelfNotExistsException extends Exception {

    public ShelfNotExistsException(String message) {
        super(message);
    }
}
