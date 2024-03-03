package com.ecommerce.react.api.repository;

import com.ecommerce.react.api.domain.Image;
import com.ecommerce.react.api.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {



}
