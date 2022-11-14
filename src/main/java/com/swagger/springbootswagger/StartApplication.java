package com.swagger.springbootswagger;

import com.swagger.springbootswagger.model.User;
import com.swagger.springbootswagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "user1", "123456");
        User user2 = new User(null, "user2", "123456");
        User user3 = new User(null, "user3", "123456");
        User user4 = new User(null, "user4", "123456");

        repository.saveAll(Arrays.asList(user1, user2, user3, user4));
    }
}
