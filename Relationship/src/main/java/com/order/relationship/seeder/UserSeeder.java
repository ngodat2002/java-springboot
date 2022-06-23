package com.order.relationship.seeder;

import com.order.relationship.entity.User;
import com.order.relationship.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserSeeder {
    public static List<User> users;
    public static final int NUMBER_OF_USER = 30;

    @Autowired
    UserRepository userRepository;

    public void generate() {
        log.debug("------------Seeding user-------------");
        Faker faker = new Faker();
        users = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_USER; i++) {
            users.add(User.builder()
                    .id(i + 1)
                    .username(faker.name().fullName())
                    .build());
        }
        userRepository.saveAll(users);
        log.debug("--------------End of seeding user-------------");
    }
}
