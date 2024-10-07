package com.course.hibernate.services;

import java.util.List;
import java.util.Optional;

import com.course.hibernate.entities.User;
import com.course.hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(Math.toIntExact(id));
        return user.get();
    }
}
