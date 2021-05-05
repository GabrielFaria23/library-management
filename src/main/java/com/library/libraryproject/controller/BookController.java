package com.library.libraryproject.controller;

import com.library.libraryproject.model.Book;
import com.library.libraryproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }
}
