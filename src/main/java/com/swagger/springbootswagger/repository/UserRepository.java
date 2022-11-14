package com.swagger.springbootswagger.repository;

import com.swagger.springbootswagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
