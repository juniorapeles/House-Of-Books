package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.entities.Categorie;
import com.techlibrary.houseofbooks.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repository;

    public List<Categorie> getAllCategories() {
        return repository.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return repository.findById(id);
    }

    public Categorie createCategorie(Categorie categorie) {
        return repository.save(categorie);
    }

    public void deleteCategorie(Long id) {
        repository.deleteById(id);
    }
}
