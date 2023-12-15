package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.CategorieDTO;
import com.techlibrary.houseofbooks.entities.Categorie;
import com.techlibrary.houseofbooks.repositories.CategorieRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Categorie> getAllCategories() {
        return repository.findAll();
    }

    public CategorieDTO getCategorieById(Long id) {
        Optional<Categorie> categorieOptional = repository.findById(id);
        Categorie entity = categorieOptional.orElseThrow(() -> new ResourceNotFoundException("Categorie not Found"));
        return new CategorieDTO(entity);
    }

    public CategorieDTO createCategorie(CategorieDTO categorieDTO) {
        Categorie cat = new Categorie(categorieDTO);
        repository.save(cat);
        return new CategorieDTO(cat);
    }


    public CategorieDTO UpdateCategorie(Long id, CategorieDTO categorieDTO) {
        Optional<Categorie> obj = repository.findById(id);
        Categorie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Categorie not Found !"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(categorieDTO, entity);
        repository.save(entity);
        return new CategorieDTO(entity);
    }

    public void deleteCategorie(Long id) {
        repository.deleteById(id);
    }
}
