package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.PublishingCompanyDTO;
import com.techlibrary.houseofbooks.entities.PublishingCompany;
import com.techlibrary.houseofbooks.repositories.RepositoryPublishingCompany;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePublishingCompany {

    @Autowired
    RepositoryPublishingCompany repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PublishingCompany> getAllPublishingCompany() {
        return repository.findAll();
    }

    public PublishingCompanyDTO getAllPublishinggetPublishingCompanyByIdCompany (Long id) {
        Optional<PublishingCompany>  publishingCompanyDTO = repository.findById(id);

        PublishingCompany entity = publishingCompanyDTO.orElseThrow(() -> new ResourceNotFoundException("Publishing Company Not Found"));
        return new PublishingCompanyDTO(entity);
    }

    public PublishingCompanyDTO createPublishingCompany(PublishingCompanyDTO publishingCompanyDTO) {
        PublishingCompany publishingCompany = new PublishingCompany(publishingCompanyDTO);
        repository.save(publishingCompany);
        return new PublishingCompanyDTO(publishingCompany
        );
    }

    public void deletePublishingCompany(Long id) {
        repository.deleteById(id);
    }

    public PublishingCompanyDTO UpdatePublishingCompany(Long id, PublishingCompanyDTO publishingCompanyDTO) {
        Optional<PublishingCompany> obj = repository.findById(id);
        PublishingCompany  entity = obj.orElseThrow(() -> new ResourceNotFoundException("PublishingCompany not found!"));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(publishingCompanyDTO, entity);
        repository.save(entity);
        return new PublishingCompanyDTO(entity);
    }
}
