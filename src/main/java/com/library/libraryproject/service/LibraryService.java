package com.library.libraryproject.service;

import com.library.libraryproject.exception.AnyFieldWrong;
import com.library.libraryproject.exception.LibraryNotExistsException;
import com.library.libraryproject.model.Library;
import com.library.libraryproject.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    public Library findById(long id) throws LibraryNotExistsException {
        return verificaLibraryId(id);
    }

    public Library create(Library library) throws AnyFieldWrong {
        Library librarySave = checkLibraryFields(library);
        return libraryRepository.save(librarySave);
    }

    public Library update(Library library, long id) throws LibraryNotExistsException, AnyFieldWrong {
        Library libraryExist = verificaLibraryId(id);
        Library libraryUpdate = checkLibraryFields(libraryExist);

        libraryUpdate.setHalls(library.getHalls());
        libraryUpdate.setLibraryName(library.getLibraryName());

        return libraryRepository.save(libraryUpdate);
    }

    public void delete(long id) throws LibraryNotExistsException {
        Library libraryDelete = verificaLibraryId(id);
        libraryRepository.delete(libraryDelete);
    }

    private Library verificaLibraryId(long id) throws LibraryNotExistsException {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotExistsException("Library with id "+ id +" doesn't exist!"));
    }

    private Library checkLibraryFields(Library library) throws AnyFieldWrong {
        if( library.getHalls() != null && library.getLibraryName() != null ) {
            return library;
        }else{
            throw new AnyFieldWrong("The fields were not filled in correctly!");
        }
    }

}
