package com.ecommerce.react.api.repository;

import com.ecommerce.react.api.domain.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
