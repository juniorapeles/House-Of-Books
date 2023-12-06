package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.CategorieDTO;
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

    public CategorieDTO getCategorieById(Long id) {
        Optional<Categorie>  categorieOptional = repository.findById(id);

        if(categorieOptional.isPresent()){
            Categorie categorie = categorieOptional.get();
            return  new CategorieDTO(categorie);
        }else{
            return null;
        }
    }

    public CategorieDTO createCategorie(CategorieDTO categorieDTO) {
       Categorie cat = new Categorie(categorieDTO);
       repository.save(cat);
       return new CategorieDTO(cat);
    }

    public void deleteCategorie(Long id) {
        repository.deleteById(id);
    }
}
