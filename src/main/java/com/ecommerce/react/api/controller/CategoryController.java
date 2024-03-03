package com.ecommerce.react.api.controller;

import com.ecommerce.react.api.domain.Category;
import com.ecommerce.react.api.domain.Product;
import com.ecommerce.react.api.service.CategoryService;
import com.ecommerce.react.api.service.ImageStoreService;
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
@RequestMapping(value= "/api/v0.1/category")
public class CategoryController {

    private static Logger log = LogManager.getLogger(CategoryController.class);

    private final CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Category>> findAll(){
        log.info("Entering findAll..");
        List<Category> list = new ArrayList<>();
        categoryService.getsAllCategory().forEach( category -> {
            list.add(category);
        });
        log.info("returning count : " +list.size() );
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        log.info("Entering createCategory..");
        category = categoryService.createdCategory(category).get();
        log.info("returning created : " +category );
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        log.info("Entering getCategoryById..");
        Category categoryId = categoryService.getCategoryById(id).get();
        log.info("returning created : " +categoryId );
        return new ResponseEntity(categoryId, HttpStatus.OK);
    }

}
