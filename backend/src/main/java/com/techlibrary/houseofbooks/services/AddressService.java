package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AddressDTO;
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

    public AddressDTO getAdressById(Long id) {
        Optional<Address> addressOptional = repository.findById(id);

        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            AddressDTO dto = new AddressDTO(address) ;
            return dto;
        }else{
            return null;
        }
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
