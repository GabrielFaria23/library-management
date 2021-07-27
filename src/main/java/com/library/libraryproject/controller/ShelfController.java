package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.LibraryNotExistsException;
import com.library.libraryproject.exception.ShelfNotExistsException;
import com.library.libraryproject.model.Library;
import com.library.libraryproject.model.Shelf;
import com.library.libraryproject.service.LibraryService;
import com.library.libraryproject.service.ShelfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Endpoint of shelves", description = "Endpoint utilized to make alterations in shelf entity", tags = "Endpoint of shelf")
@RestController
@RequestMapping(value = "/v1/shelfs")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping
    @ApiOperation(value = "Find all shelves")
    public List<Shelf> findAll(){
        return shelfService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find a shelf by id")
    public ResponseEntity<Shelf> findById(@PathVariable @Valid long id) throws ShelfNotExistsException {
        return ResponseEntity.ok(shelfService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create a new shelf")
    public ResponseEntity<Shelf> create(@RequestBody @Valid Shelf shelf) throws AnyFieldWrong {
        return ResponseEntity.ok(shelfService.create(shelf));
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "Update a shelf")
    public ResponseEntity<Shelf> update(@PathVariable @Valid long id, @RequestBody @Valid Shelf shelf) throws ShelfNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(shelfService.update(shelf, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a shelf by id")
    public void delete(@PathVariable @Valid long id) throws ShelfNotExistsException {
        shelfService.delete(id);
    }
}
