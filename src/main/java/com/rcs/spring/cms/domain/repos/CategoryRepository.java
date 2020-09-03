package com.rcs.spring.cms.domain.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rcs.spring.cms.domain.entities.Category;

import reactor.core.publisher.Flux;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
    Flux<Category> findByName(String name);

    Flux<Category> findByNameStartingWithIgnoreCase(String name);
}
