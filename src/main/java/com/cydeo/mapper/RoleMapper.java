package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // convert to entity

    public Role convertEntity(RoleDTO roleDTO) {
       return modelMapper.map(roleDTO, Role.class);
    }


    // convert to dto

    public RoleDTO convertToDTO(Role role) {
        return modelMapper.map(role,RoleDTO.class);
    }

}
