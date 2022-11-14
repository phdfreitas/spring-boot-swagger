package com.swagger.springbootswagger.service;

import com.swagger.springbootswagger.model.User;
import com.swagger.springbootswagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int daysCalculatorWithDatabase(String login) {
        Optional<User> userOptional = userRepository.findByUsername(login);
        return Period.between(userOptional.get().getCreatedAt(), userOptional.get().getUpdatedAt()).getDays();
    }
}
