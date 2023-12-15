package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.dto.UserDTO;
import com.techlibrary.houseofbooks.entities.User;
import com.techlibrary.houseofbooks.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = service.getAUserById(id);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> CreateUser(@RequestBody UserDTO userDTO) {
        UserDTO createUser = service.CreateUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> UpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = service.UpdateUser(id, userDTO);
        return ResponseEntity.ok().body(updatedUser);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
