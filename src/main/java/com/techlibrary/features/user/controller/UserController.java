package com.techlibrary.features.user.controller;

import com.techlibrary.generics.GenericController;
import com.techlibrary.features.user.dto.UserDTO;
import com.techlibrary.generics.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends GenericController<UserDTO, Long> {

    public UserController(GenericService<UserDTO, Long> service) {
        super(service);
    }

}