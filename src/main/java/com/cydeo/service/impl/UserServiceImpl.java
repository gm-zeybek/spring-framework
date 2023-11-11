package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll(Sort.by("firstName")); // repository method has properties
        return userList.stream().map(userMapper::convertDTO).collect(Collectors.toList());
    }


    @Override
    public UserDTO findByUserName(String username) {

         return userMapper.convertDTO(userRepository.findByUserName(username));
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = userMapper.convertUser(userDTO);
        userRepository.save(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        // find current user
       User user = userRepository.findByUserName(userDTO.getUserName());
       // capture current user id
       Long id = user.getId();
       // find converted user
        User convertedUser = userMapper.convertUser(userDTO);
        // assign converted user captured id
        convertedUser.setId(id);
        userRepository.save(convertedUser);
        return findByUserName(userDTO.getUserName());

    }

    @Override
    public void deleteByUserName(String userName) {

    }
}
