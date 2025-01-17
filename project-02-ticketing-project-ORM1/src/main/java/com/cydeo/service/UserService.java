package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService  {


    List<UserDTO> getAllUsers();// service layer allways call DTO

    UserDTO findByUserName(String username); // again userDTO

    void save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void deleteByUserName(String userName);

    void delete(String userName);

    List<UserDTO> listAllByRole(String role); // we did generic code to use other places

}
