package com.course.hibernate.config;

import java.util.Arrays;

import com.course.hibernate.entities.User;
import com.course.hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "John Doe", "johndoe@example.com", "+098629102727192", "123456");
        User user2 = new User(null, "Steve McCain", "stevemccain@example.com", "+098629102727190", "123456");
        User user3 = new User(null, "Stanley Brown", "stanleybrown@example.com", "+098629102727191", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
