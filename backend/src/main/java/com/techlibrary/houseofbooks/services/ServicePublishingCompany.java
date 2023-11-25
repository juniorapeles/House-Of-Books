package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.entities.PublishingCompany;
import com.techlibrary.houseofbooks.repositories.RepositoryPublishingCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePublishingCompany {

    @Autowired
    RepositoryPublishingCompany repository;

    public List<PublishingCompany> getAllPublishingCompany() {
        return repository.findAll();
    }

    public Optional<PublishingCompany> getPublishingCompanyById(Long id) {
        return repository.findById(id);
    }

    public PublishingCompany createPublishingCompany(PublishingCompany publishingCompany) {
        return repository.save(publishingCompany);
    }

    public void deletePublishingCompany(Long id) {
        repository.deleteById(id);
    }
}
