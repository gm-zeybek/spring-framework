package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    List<User> findAllByIsDeletedIs(Boolean isDeleted);

    void deleteByUserName(String userName);

    List<User> findAllByRoleDescriptionIgnoringCase(String description);

}
