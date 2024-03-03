package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Orders;
import com.ecommerce.react.api.repository.OrdersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

    private static Logger logger = LogManager.getLogger(OrdersService.class);

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Iterable<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}
