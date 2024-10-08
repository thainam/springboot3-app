package com.course.hibernate.services;

import java.util.List;
import java.util.Optional;

import com.course.hibernate.entities.Order;
import com.course.hibernate.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = repository.findById(Math.toIntExact(id));
        return order.get();
    }
}
