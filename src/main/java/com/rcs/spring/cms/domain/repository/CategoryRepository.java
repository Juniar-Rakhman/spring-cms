package com.rcs.spring.cms.domain.repository;

import com.rcs.spring.cms.domain.models.Category;
import java.util.List;

public interface CategoryRepository extends AbstractRepository<Category> {
    List<Category> findByName(String name);
    List<Category> findByNameStartingWithIgnoreCase(String name);
}
