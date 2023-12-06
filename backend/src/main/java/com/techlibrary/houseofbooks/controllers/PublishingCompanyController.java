package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.dto.PublishingCompanyDTO;
import com.techlibrary.houseofbooks.entities.PublishingCompany;
import com.techlibrary.houseofbooks.services.ServicePublishingCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PublishingCompanyDTO> getPublishingCompanyById(@PathVariable Long id) {
        PublishingCompanyDTO publishingCompanyDTO = service.getAllPublishinggetPublishingCompanyByIdCompany(id);
        if(publishingCompanyDTO != null){
            return ResponseEntity.ok(publishingCompanyDTO);
        }else{
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping
    public ResponseEntity<PublishingCompanyDTO> createPublishingCompany(@RequestBody PublishingCompanyDTO publishingCompanyDTO) {
        PublishingCompanyDTO createPublishingCompany = service.createPublishingCompany(publishingCompanyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPublishingCompany);
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
