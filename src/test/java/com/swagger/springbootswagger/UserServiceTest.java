package com.swagger.springbootswagger;

import com.swagger.springbootswagger.model.User;
import com.swagger.springbootswagger.repository.UserRepository;
import com.swagger.springbootswagger.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration{
        @Bean
        public UserService userService(){
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void userServiceDaysCalculator(){
        String login = "pedro";
        int days = userService.daysCalculatorWithDatabase(login);

        Assertions.assertEquals(days, 10);
    }

    @Before
    public void setup(){
        LocalDate createdAt = LocalDate.parse("2022-11-04");
        LocalDate updatedAt = LocalDate.parse("2022-11-14");

        User user = new User(1L, "pedro", "123456", createdAt, updatedAt);

        Mockito.when(userRepository.findByUsername(user.getLogin()))
                .thenReturn(Optional.of(user));
    }

}
