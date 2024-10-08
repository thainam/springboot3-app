package com.course.hibernate.config;

import java.time.Instant;
import java.util.Arrays;

import com.course.hibernate.entities.Order;
import com.course.hibernate.entities.User;
import com.course.hibernate.entities.enums.OrderStatus;
import com.course.hibernate.repositories.OrderRepository;
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

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "John Doe", "johndoe@example.com", "+098629102727192", "123456");
        User user2 = new User(null, "Steve McCain", "stevemccain@example.com", "+098629102727190", "123456");
        User user3 = new User(null, "Stanley Brown", "stanleybrown@example.com", "+098629102727191", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, user3);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
