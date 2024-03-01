package com.ecommerce.react.api.controller;

import com.ecommerce.react.api.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "/api/product")
public class ProductController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> findAll(){
        Product pro = new Product();
        pro.setId(1L);
        pro.setName("Marisco");
        List<Product> list = new ArrayList<>();
        list.add(pro);
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
