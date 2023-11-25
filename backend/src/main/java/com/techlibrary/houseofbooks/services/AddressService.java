package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public List<Address> getAllAddress() {
        return repository.findAll();
    }
    public Optional<Address> getAdressById(Long id) {
        return repository.findById(id);
    }

    public Address CreateAddress(Address address) {
        return repository.save(address);
    }

    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }
}
