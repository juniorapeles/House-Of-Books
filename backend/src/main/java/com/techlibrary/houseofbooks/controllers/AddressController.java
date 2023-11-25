package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Address")
public class AddressController {
    @Autowired
    private AddressService service;
    @GetMapping
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return service.getAdressById(id);
    }

    @PostMapping
    public Address CreateAddress(@RequestBody Address address) {
        return service.CreateAddress(address);
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
