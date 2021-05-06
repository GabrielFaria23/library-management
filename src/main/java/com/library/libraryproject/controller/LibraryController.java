package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.LibraryNotExistsException;
import com.library.libraryproject.model.Library;
import com.library.libraryproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/librarys")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<Library> findAll(){
        return libraryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Library> findById(@PathVariable @Valid long id) throws LibraryNotExistsException {
        return ResponseEntity.ok(libraryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Library> create(@RequestBody @Valid Library library) throws AnyFieldWrong {
        return ResponseEntity.ok(libraryService.create(library));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Library> update(@PathVariable @Valid long id, @RequestBody @Valid Library library) throws LibraryNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(libraryService.update(library, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid long id) throws LibraryNotExistsException {
        libraryService.delete(id);
    }
}
