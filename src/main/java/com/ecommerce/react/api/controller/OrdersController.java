package com.ecommerce.react.api.controller;

import com.ecommerce.react.api.domain.Orders;
import com.ecommerce.react.api.domain.Product;
import com.ecommerce.react.api.service.CategoryService;
import com.ecommerce.react.api.service.OrdersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping(value= "/api/v0.1/orders")
public class OrdersController {

    private static Logger log = LogManager.getLogger(OrdersController.class);

    private final OrdersService ordersService;


    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Orders>> findAll(){
        log.info("Entering findAll..");
        List<Orders> list = new ArrayList<>();
        ordersService.getAllOrders().forEach( order -> {
            list.add(order);
        });
        log.info("returning count : " +list.size() );
        return new ResponseEntity(list, HttpStatus.OK);
    }



}
