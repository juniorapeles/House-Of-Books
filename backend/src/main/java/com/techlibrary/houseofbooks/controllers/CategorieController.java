package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Categorie;
import com.techlibrary.houseofbooks.services.AuthorService;
import com.techlibrary.houseofbooks.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Categorie")
public class CategorieController {
    @Autowired
    private CategorieService service;
    @GetMapping
    public List<Categorie> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Categorie> getCategorieById(@PathVariable Long id) {
        return service.getCategorieById(id);
    }

    @PostMapping
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return service.createCategorie(categorie);
    }

//    @PutMapping("/{id}")
//    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
//        return authorService.updateAuthor(id, author);
//    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        service.deleteCategorie(id);
    }
}
