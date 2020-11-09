package com.example.tacos.data;

import com.example.tacos.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends  CrudRepository <Order, Long> {
}
