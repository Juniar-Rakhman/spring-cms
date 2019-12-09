package com.rcs.spring.cms.domain.repository;

import com.rcs.spring.cms.domain.models.User;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User> {
    Optional<User> findUserByName(String name);
}
