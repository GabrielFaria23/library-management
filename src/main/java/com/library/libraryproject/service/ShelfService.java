package com.library.libraryproject.service;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.ShelfNotExistsException;
import com.library.libraryproject.model.Shelf;
import com.library.libraryproject.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {

    @Autowired
    private ShelfRepository shelfRepository;

    public List<Shelf> findAll() {
        return shelfRepository.findAll();
    }

    public Shelf findById(long id) throws ShelfNotExistsException {
        return verificaShelfId(id);
    }

    public Shelf create(Shelf shelf) throws AnyFieldWrong {
        Shelf shelfSave = checkShelfFields(shelf);
        return shelfRepository.save(shelfSave);
    }

    public Shelf update(Shelf shelf, long id) throws ShelfNotExistsException, AnyFieldWrong {
        Shelf shelfExist = verificaShelfId(id);
        Shelf shelfUpdate = checkShelfFields(shelfExist);

        shelfUpdate.setBooks(shelf.getBooks());
        shelfUpdate.setShelfName(shelf.getShelfName());
        shelfUpdate.setHall(shelf.getHall());

        return shelfRepository.save(shelfUpdate);
    }

    public void delete(long id) throws ShelfNotExistsException {
        Shelf shelfDelete = verificaShelfId(id);
        shelfRepository.delete(shelfDelete);
    }

    private Shelf verificaShelfId(long id) throws ShelfNotExistsException {
        return shelfRepository.findById(id)
                .orElseThrow(() -> new ShelfNotExistsException("Shelf with id "+ id +" doesn't exist!"));
    }

    private Shelf checkShelfFields(Shelf shelf) throws AnyFieldWrong {
        if( shelf.getHall() != null && shelf.getShelfName() != null ) {
            return shelf;
        }else{
            throw new AnyFieldWrong("The fields were not filled in correctly!");
        }
    }

}
