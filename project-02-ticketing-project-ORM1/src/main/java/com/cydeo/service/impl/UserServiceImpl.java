package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional // it is for crud derive queries (@Modifying for @Query)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<UserDTO> getAllUsers() {
//        List<User> userList = userRepository.findAllByIsDeletedIs(false); // repository method has properties
        List<User> userList = userRepository.findAll(); // repository method has properties
        return userList.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }


    @Override
    public UserDTO findByUserName(String username) {

        User user = userRepository.findByUserName(username);
        return userMapper.convertToDTO(user);
    }

    @Override
    public void save(UserDTO userDTO) {
        userDTO.setEnabled(true);
        User obj = userMapper.convertToEntity(userDTO);
        obj.setPassWord(passwordEncoder.encode(obj.getPassWord()));
        userRepository.save(obj);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        // find current user
       User user = userRepository.findByUserName(userDTO.getUserName());
       // capture current user id
       Long id = user.getId();
       // find converted user
        User convertedUser = userMapper.convertToEntity(userDTO);
        // assign converted user captured id
        convertedUser.setId(id);
        userRepository.save(convertedUser);
        return findByUserName(userDTO.getUserName());

    }

    @Override
    public void deleteByUserName(String userName) {
        userRepository.deleteByUserName(userName);
    }

    @Override
    public void delete(String userName) {
        User user = userRepository.findByUserName(userName);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> listOfUsers= userRepository.findAllByRoleDescriptionIgnoreCase(role);
        return listOfUsers.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }


}
