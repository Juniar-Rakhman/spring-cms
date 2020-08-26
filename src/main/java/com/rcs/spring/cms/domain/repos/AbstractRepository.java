package com.rcs.spring.cms.domain.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T> extends MongoRepository<T, String> {
}
