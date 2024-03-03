package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Iterable<Category> getsAllCategory();

    Optional<Category> getCategoryById(Long id);


    Optional<Category> createdCategory(Category entity);

}
