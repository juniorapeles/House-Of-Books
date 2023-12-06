package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.dto.CategorieDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Categorie;
import com.techlibrary.houseofbooks.services.AuthorService;
import com.techlibrary.houseofbooks.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategorieDTO> getCategorieById(@PathVariable Long id) {
        CategorieDTO categorieDTO = service.getCategorieById(id);

        if(categorieDTO != null ){
            return ResponseEntity.ok(categorieDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategorieDTO> createCategorie(@RequestBody CategorieDTO categorieDTO) {
        CategorieDTO createCategorie = service.createCategorie(categorieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategorie);
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
