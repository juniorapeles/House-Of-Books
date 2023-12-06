package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.dto.AuthorDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        AuthorDTO authorDTO = service.getAuthorById(id);

        if(authorDTO != null){
            return ResponseEntity.ok(authorDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO createAuthor = service.createAuthor(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }

//    @PutMapping("/{id}")
//    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
//        return authorService.updateAuthor(id, author);
//    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
    }
}
