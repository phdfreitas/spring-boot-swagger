package com.swagger.springbootswagger.controller;

import com.swagger.springbootswagger.handler.BusinessException;
import com.swagger.springbootswagger.model.User;
import com.swagger.springbootswagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers(){
        return repository.findAll();
    }

    @PostMapping
    public void save(User user){

        if(user.getLogin() == null)
            throw new BusinessException("Login deve ser informado.");

        repository.save(user);
    }

}
