package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.LibraryNotExistsException;
import com.library.libraryproject.model.Library;
import com.library.libraryproject.service.LibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Endpoint of libraries", description = "Endpoint utilized to make alterations in library entity", tags = "Endpoint of library")
@RestController
@RequestMapping(value = "/v1/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    @ApiOperation(value = "Find all libraries")
    public List<Library> findAll(){
        return libraryService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find a library by id")
    public ResponseEntity<Library> findById(@PathVariable @Valid long id) throws LibraryNotExistsException {
        return ResponseEntity.ok(libraryService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create a new library")
    public ResponseEntity<Library> create(@RequestBody @Valid Library library) throws AnyFieldWrong {
        return ResponseEntity.ok(libraryService.create(library));
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "Update a library")
    public ResponseEntity<Library> update(@PathVariable @Valid long id, @RequestBody @Valid Library library) throws LibraryNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(libraryService.update(library, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a library by id")
    public void delete(@PathVariable @Valid long id) throws LibraryNotExistsException {
        libraryService.delete(id);
    }
}
