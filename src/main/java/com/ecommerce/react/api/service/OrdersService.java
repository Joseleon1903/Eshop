package com.ecommerce.react.api.service;

import com.ecommerce.react.api.domain.Category;
import com.ecommerce.react.api.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    Iterable<Orders> getAllOrders();
}
