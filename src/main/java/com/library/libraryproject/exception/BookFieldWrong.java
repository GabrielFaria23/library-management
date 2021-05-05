package com.library.libraryproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookFieldWrong extends Throwable {

    public BookFieldWrong(String message) {
        super(message);
    }
}
