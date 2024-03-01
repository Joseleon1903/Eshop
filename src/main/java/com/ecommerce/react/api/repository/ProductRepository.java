package com.ecommerce.react.api.repository;

import com.ecommerce.react.api.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
