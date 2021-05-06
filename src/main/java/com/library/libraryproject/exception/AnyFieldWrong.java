package com.library.libraryproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnyFieldWrong extends Exception {

    public AnyFieldWrong(String message) {
        super(message);
    }
}
