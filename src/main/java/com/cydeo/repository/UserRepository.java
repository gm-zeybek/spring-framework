package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

}
