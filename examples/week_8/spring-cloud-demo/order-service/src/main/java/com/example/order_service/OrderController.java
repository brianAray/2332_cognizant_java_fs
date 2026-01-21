package com.example.order_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();
    {
        orders.add(new Order(1, 1, "Mouse", 39.99F));
        orders.add(new Order(2, 2, "Laptop", 329.99F));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id){
        for(Order order: orders){
            if(order.getId().equals(id)){
                return ResponseEntity.ok().body(order);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Exception("Not found"));
    }
}
