package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Product;
import com.ecommerce.react.api.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private static Logger logger = LogManager.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository= productRepository;
    }

    @Override
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> saveProduct(Product entity) {
        Product prod = productRepository.save(entity);
        return Optional.of(prod);
    }

    @Override
    public Optional<Product> updateProduct(Product entity) {
        if(productRepository.findById(entity.getId()).isPresent()) {
            entity = productRepository.save(entity);
        }
        return Optional.of(entity);
    }

    @Override
    public Optional<Product> findProduct(Long id) {
        return Optional.of(productRepository.findById(id).get());
    }
}
