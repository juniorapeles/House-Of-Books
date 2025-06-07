package com.techlibrary.features.user.mapper;

import com.techlibrary.features.user.dto.UserDTO;
import com.techlibrary.features.user.domain.User;
import com.techlibrary.generics.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {

}