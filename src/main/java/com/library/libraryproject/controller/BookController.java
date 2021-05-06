package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.BookNotExistsException;
import com.library.libraryproject.model.Book;
import com.library.libraryproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable @Valid long id) throws BookNotExistsException {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) throws AnyFieldWrong {
        return ResponseEntity.ok(bookService.create(book));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Book> update(@PathVariable @Valid long id, @RequestBody @Valid Book book) throws BookNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(bookService.update(book, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid long id) throws BookNotExistsException {
        bookService.delete(id);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<Book>> filterBookTitle(){
        return ResponseEntity.ok(bookService.filterBookTitle("Java"));
    }
}
