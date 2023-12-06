package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.UserDTO;
import com.techlibrary.houseofbooks.entities.User;
import com.techlibrary.houseofbooks.repositories.UserRepository;
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

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDTO(user);
        } else {
            return null;
        }
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
