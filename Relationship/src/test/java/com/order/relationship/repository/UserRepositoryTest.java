package com.order.relationship.repository;

import com.order.relationship.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    //save user junit test
    @Test
    public void saveUser(){
        User user = User.builder()
                .id(1)
                .username("Ngo Chi Thanh Dat")
        .build();
        userRepository.save(user);
    }
}