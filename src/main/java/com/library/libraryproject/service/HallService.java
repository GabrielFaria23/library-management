package com.library.libraryproject.service;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.HallNotExistsException;
import com.library.libraryproject.model.Hall;
import com.library.libraryproject.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    public Hall findById(long id) throws HallNotExistsException {
        return verificaHallId(id);
    }

    public Hall create(Hall hall) throws AnyFieldWrong {
        Hall hallSave = checkHallFields(hall);
        return hallRepository.save(hallSave);
    }

    public Hall update(Hall hall, long id) throws HallNotExistsException, AnyFieldWrong {
        Hall hallExist = verificaHallId(id);
        Hall hallUpdate = checkHallFields(hallExist);

        hallUpdate.setBooks(hall.getBooks());
        hallUpdate.setHallName(hall.getHallName());
        hallUpdate.setShelfs(hall.getShelfs());

        return hallRepository.save(hallUpdate);
    }

    public void delete(long id) throws HallNotExistsException {
        Hall hallDelete = verificaHallId(id);
        hallRepository.delete(hallDelete);
    }

    private Hall verificaHallId(long id) throws HallNotExistsException {
        return hallRepository.findById(id)
                .orElseThrow(() -> new HallNotExistsException("Hall with id "+ id +" doesn't exist!"));
    }

    private Hall checkHallFields(Hall hall) throws AnyFieldWrong {
        if(hall.getHallName() != null ) {
            return hall;
        }else{
            throw new AnyFieldWrong("The fields were not filled in correctly!");
        }
    }

}
