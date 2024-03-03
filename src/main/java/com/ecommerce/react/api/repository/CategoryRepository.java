package com.ecommerce.react.api.repository;

import com.ecommerce.react.api.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
