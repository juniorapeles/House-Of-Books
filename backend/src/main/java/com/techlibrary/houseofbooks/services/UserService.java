package com.techlibrary.houseofbooks.services;

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

    public Optional<User> getAUserById(Long id) {
        return repository.findById(id);
    }

    public User CreateUser(User user){
        return repository.save(user);
    }


    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
