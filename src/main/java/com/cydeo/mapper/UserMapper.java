package com.cydeo.mapper;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // DTO converter
    public UserDTO convertDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }

    // Entity convertUser
    public User convertUser(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
}
