package com.example.tacos.data;

import com.example.tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends  CrudRepository <Order, Long> {
}
