package com.library.libraryproject.service;

import com.library.libraryproject.exception.BookFieldWrong;
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

    public Book create(Book book) throws BookFieldWrong {
        Book bookSave = checkBookFields(book);
        return bookRepository.save(bookSave);
    }

    public Book update(Book book, long id) throws BookNotExistsException {
        Book bookUpdate = verificaBookId(id);

        bookUpdate.setAuthor(book.getAuthor());
        bookUpdate.setDescription(book.getDescription());
        bookUpdate.setHall(book.getHall());
        bookUpdate.setPublication_date(book.getPublication_date());
        bookUpdate.setTitle(book.getTitle());
        bookUpdate.setShelf(book.getShelf());

        return bookRepository.save(bookUpdate);
    }

    public void delete(long id) throws BookNotExistsException {
        Book bookDelete = verificaBookId(id);
        bookRepository.delete(bookDelete);
    }

    private Book verificaBookId(long id) throws BookNotExistsException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotExistsException("Book with id + "+ id +" doesn't exist!"));
    }

    private Book checkBookFields(Book book) throws BookFieldWrong {
        if( book.getAuthor() != null && book.getDescription() != null && book.getHall() != null && book.getPublication_date() != null && book.getShelf() != null && book.getTitle() != null) {
            return book;
        }else{
            throw new BookFieldWrong("The fields were not filled in correctly!");
        }
    }

}
