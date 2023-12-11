package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AuthorDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.repositories.AuthorRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
       Author author = new Author(authorDTO);
       repository.save(author);
       return new AuthorDTO(author);
    }

    public AuthorDTO getAuthorById(Long id) {
        Optional<Author> authorOptional =  repository.findById(id);
        Author entity = authorOptional.orElseThrow(() -> new ResourceNotFoundException("Author not Found"));
        return new AuthorDTO(entity);
    }


    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

//    public Author updateAuthor(Long id, Author updatedAuthor) {
//        Optional<Author> optionalAuthor = repository.findById(id);
//
//        if (optionalAuthor.isPresent()) {
//            Author existingAuthor = optionalAuthor.get();
//            existingAuthor.setName(updatedAuthor.getName());
//            existingAuthor.setBiography(updatedAuthor.getBiography());
//
//            return repository.save(existingAuthor);
//        } else {
//            // Lógica para tratar o autor não encontrado
//            return null; // ou lançar uma exceção, dependendo do caso
//        }
//    }
}
