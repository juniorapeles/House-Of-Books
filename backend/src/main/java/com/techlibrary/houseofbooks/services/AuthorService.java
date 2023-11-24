package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.repositories.AuthorRepository;
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

    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    public Optional<Author> getAuthorById(Long id) {
        return repository.findById(id);
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
