package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts();

    Optional<Product> saveProduct(Product entity);

    Optional<Product> updateProduct(Product entity);

    Optional<Product> findProduct(Long id);

}
