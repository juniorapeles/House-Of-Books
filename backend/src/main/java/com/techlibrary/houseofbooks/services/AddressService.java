package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.repositories.AddressRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private ModelMapper modelMapper;

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

    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        Optional<Address> oldObj = repository.findById(id);
        Address entity = oldObj.orElseThrow(() -> new ResourceNotFoundException("Address not Found"));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(addressDTO,entity);
        repository.save(entity);
        return new AddressDTO(entity);
    }
    public void deleteAddress(Long id) {
       try{
           repository.deleteById(id);
       }catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException("Id not Found " + id);
       }catch (DataIntegrityViolationException e){
           throw new ResourceNotFoundException("Integrity violation");
       }
    }
}
