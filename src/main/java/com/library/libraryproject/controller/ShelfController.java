package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.LibraryNotExistsException;
import com.library.libraryproject.exception.ShelfNotExistsException;
import com.library.libraryproject.model.Library;
import com.library.libraryproject.model.Shelf;
import com.library.libraryproject.service.LibraryService;
import com.library.libraryproject.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/shelfs")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping
    public List<Shelf> findAll(){
        return shelfService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Shelf> findById(@PathVariable @Valid long id) throws ShelfNotExistsException {
        return ResponseEntity.ok(shelfService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Shelf> create(@RequestBody @Valid Shelf shelf) throws AnyFieldWrong {
        return ResponseEntity.ok(shelfService.create(shelf));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Shelf> update(@PathVariable @Valid long id, @RequestBody @Valid Shelf shelf) throws ShelfNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(shelfService.update(shelf, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid long id) throws ShelfNotExistsException {
        shelfService.delete(id);
    }
}
