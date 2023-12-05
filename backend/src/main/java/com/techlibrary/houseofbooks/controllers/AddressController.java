package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        AddressDTO createdAddress = service.createAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

//    @PutMapping("/{id}")
//    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
//        return authorService.updateAuthor(id, author);
//    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }
}
