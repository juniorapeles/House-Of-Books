package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.repositories.AddressRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    public List<Address> getAllAddress() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public AddressDTO getAdressById(Long id) {
        Optional<Address> obj = repository.findById(id);
        Address entity = obj.orElseThrow(() -> new ResourceNotFoundException("Address not Found"));
        return new AddressDTO(entity) ;
    }

    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address add = new Address(addressDTO);
        repository.save(add);
        return new AddressDTO(add);
   }

    private Address convertToAddresEntity(AddressDTO addressDTO){
        return new Address(addressDTO);
    }

    private AddressDTO convertToAddressDTO(Address address){
        return new AddressDTO(address);
    }


    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }
}
