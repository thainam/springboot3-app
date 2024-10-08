package com.course.hibernate.services;

import java.util.List;
import java.util.Optional;

import com.course.hibernate.entities.Category;
import com.course.hibernate.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(Math.toIntExact(id));
        return repository.findById(Math.toIntExact(id)).orElse(null);
    }
}
