package com.library.libraryproject.service;

import com.library.libraryproject.exception.BookNotExistsException;
import com.library.libraryproject.model.Book;
import com.library.libraryproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(long id) throws BookNotExistsException {
        return verificaBookId(id);
    }

    public Book create(Book book){
        
    }

    private Book verificaBookId(long id) throws BookNotExistsException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotExistsException("Book with id + "+ id +" doesn't exist!"));
    }
}
