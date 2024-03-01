package com.ecommerce.react.api.controller;

import com.ecommerce.react.api.domain.Product;
import com.ecommerce.react.api.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/api/v0.1/product")
public class ProductController {

    private static Logger log = LogManager.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> findAll(){
        log.info("Entering findAll..");
        List<Product> list = new ArrayList<>();
        productService.findAllProducts().forEach( prod -> {
            list.add(prod);
        });
        log.info("returning count : " +list.size() );
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        log.info("Entering createProduct..");
        productService.saveProduct(product).get();
        return   ResponseEntity.ok().build();
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        log.info("Entering updateProduct..");
        productService.updateProduct(product).get();
        return   ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        log.info("Entering findById..");
        Product prod = productService.findProduct(id).get();
        log.info("Returning "+ prod);
        return new ResponseEntity(prod, HttpStatus.OK);
    }

}
