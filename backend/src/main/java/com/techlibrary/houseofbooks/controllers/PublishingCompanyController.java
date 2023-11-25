package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.entities.PublishingCompany;
import com.techlibrary.houseofbooks.services.ServicePublishingCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PublishingCompany")
public class PublishingCompanyController {
    @Autowired
    private ServicePublishingCompany service;
    @GetMapping
    public List<PublishingCompany> getAllPublishingCompany() {
        return service.getAllPublishingCompany();
    }

    @GetMapping("/{id}")
    public Optional<PublishingCompany> getPublishingCompanyById(@PathVariable Long id) {
        return service.getPublishingCompanyById(id);
    }

    @PostMapping
    public PublishingCompany createPublishingCompany(@RequestBody PublishingCompany publishingCompany) {
        return service.createPublishingCompany(publishingCompany);
    }

//    @PutMapping("/{id}")
//    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
//        return service.updateAuthor(id, author);
//    }

    @DeleteMapping("/{id}")
    public void DeletePublishingCompany(@PathVariable Long id) {
        service.deletePublishingCompany(id);
    }
}
