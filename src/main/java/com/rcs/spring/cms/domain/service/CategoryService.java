package com.rcs.spring.cms.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcs.spring.cms.domain.entities.Category;
import com.rcs.spring.cms.domain.exceptions.CategoryNotFoundException;
import com.rcs.spring.cms.domain.repos.CategoryRepository;
import com.rcs.spring.cms.domain.requests.CategoryRequest;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(String id, CategoryRequest request) {
        Category category = findOne(id);

        if (category != null) {
            category.setName(request.getName());
            category = this.categoryRepository.save(category);
        }

        return category;
    }

    public Category create(CategoryRequest request) {
        Category category = Category.builder()
            .name(request.getName())
            .build();
        return this.categoryRepository.save(category);
    }

    public void delete(String id) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        category.ifPresent(this.categoryRepository::delete);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public List<Category> findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    public List<Category> findByNameStartingWith(String name) {
        return this.categoryRepository.findByNameStartingWithIgnoreCase(name);
    }

    public Category findOne(String id) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundException(id);
        }
    }
}
