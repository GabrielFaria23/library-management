package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.BookNotExistsException;
import com.library.libraryproject.model.Book;
import com.library.libraryproject.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Endpoint of Books", description = "Endpoint utilized to make alterations in book entity", tags = "Endpoint of books")
@RestController
@RequestMapping(value = "/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ApiOperation(value = "Find all books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find a book by id")
    public ResponseEntity<Book> findById(@PathVariable @Valid long id) throws BookNotExistsException {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create a new book")
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) throws AnyFieldWrong {
        return ResponseEntity.ok(bookService.create(book));
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "Update a exist book")
    public ResponseEntity<Book> update(@PathVariable @Valid long id, @RequestBody @Valid Book book) throws BookNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(bookService.update(book, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a book by id")
    public void delete(@PathVariable @Valid long id) throws BookNotExistsException {
        bookService.delete(id);
    }

    @GetMapping(value = "/filter")
    @ApiOperation(value = "Filter all books by title")
    public ResponseEntity<List<Book>> filterBookTitle(){
        return ResponseEntity.ok(bookService.filterBookTitle("Java"));
    }
}
