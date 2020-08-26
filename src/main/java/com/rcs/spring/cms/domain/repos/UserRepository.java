package com.rcs.spring.cms.domain.repos;

import com.rcs.spring.cms.domain.entities.User;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User> {
    Optional<User> findUserByName(String name);
}
