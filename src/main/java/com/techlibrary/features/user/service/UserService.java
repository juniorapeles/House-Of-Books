package com.techlibrary.features.user.service;

import com.techlibrary.features.user.dto.UserDTO;
import com.techlibrary.features.user.domain.User;
import com.techlibrary.features.user.mapper.UserMapper;
import com.techlibrary.generics.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<User, UserDTO, Long, UserMapper> {

    public UserService(JpaRepository<User, Long> repository, UserMapper mapper) {
        super(repository, mapper);
    }

}