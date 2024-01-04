package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Address")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id){
        AddressDTO addressDTO = service.getAdressById(id);

        if(addressDTO != null){
            return ResponseEntity.ok(addressDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<AddressDTO>createAddress(@RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddressDTO = service.createAddress(addressDTO);
        return ResponseEntity.ok().body(updatedAddressDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAuthor(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddress = service.updateAuthor(id,addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }
}
