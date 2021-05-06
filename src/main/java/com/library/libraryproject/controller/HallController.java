package com.library.libraryproject.controller;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.HallNotExistsException;
import com.library.libraryproject.model.Hall;
import com.library.libraryproject.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @GetMapping
    public List<Hall> findAll(){
        return hallService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hall> findById(@PathVariable @Valid long id) throws HallNotExistsException {
        return ResponseEntity.ok(hallService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Hall> create(@RequestBody @Valid Hall hall) throws AnyFieldWrong {
        return ResponseEntity.ok(hallService.create(hall));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Hall> update(@PathVariable @Valid long id, @RequestBody @Valid Hall hall) throws HallNotExistsException, AnyFieldWrong {
        return ResponseEntity.ok(hallService.update(hall, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid long id) throws HallNotExistsException {
        hallService.delete(id);
    }
}
