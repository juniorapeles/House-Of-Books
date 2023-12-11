package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.UserDTO;
import com.techlibrary.houseofbooks.entities.User;
import com.techlibrary.houseofbooks.repositories.UserRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public UserDTO getAUserById(Long id) {
        Optional<User> userOptional = repository.findById(id);

        User entity = userOptional.orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        return new UserDTO(entity);
    }

    public UserDTO CreateUser(UserDTO userDTO) {
        User user = new User(userDTO);
        repository.save(user);
        return new UserDTO(user);
    }


    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
