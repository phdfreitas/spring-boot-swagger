package com.swagger.springbootswagger.repository;

import com.swagger.springbootswagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String login);

}
