package com.rcs.spring.cms.domain.repos;

import com.rcs.spring.cms.domain.entities.Category;
import java.util.List;

public interface CategoryRepository extends AbstractRepository<Category> {
    List<Category> findByName(String name);
    List<Category> findByNameStartingWithIgnoreCase(String name);
}
