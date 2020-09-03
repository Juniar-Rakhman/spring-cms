package com.rcs.spring.cms.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcs.spring.cms.domain.entities.Category;
import com.rcs.spring.cms.domain.repos.CategoryRepository;
import com.rcs.spring.cms.domain.requests.CategoryRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Mono<Category> update(String id, CategoryRequest category) {
        return this.categoryRepository.findById(id).flatMap(entity -> {
            entity.setName(category.getName());
            return this.categoryRepository.save(entity);
        });
    }

    public Mono<Category> create(CategoryRequest request) {
        Category category = Category.builder()
            .name(request.getName())
            .build();
        return this.categoryRepository.save(category);
    }

    public void delete(String id) {
        this.categoryRepository.deleteById(id);
    }

    public Flux<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Flux<Category> findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    public Flux<Category> findByNameStartingWith(String name) {
        return this.categoryRepository.findByNameStartingWithIgnoreCase(name);
    }

    public Mono<Category> findOne(String id) {
        return this.categoryRepository.findById(id);
    }
}
