package com.example.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private AuthServiceClient authServiceClient;

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

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestHeader("Authorization") String authHeader, @RequestBody OrderRequest request){
        // fetch the user from user-service
        AuthResponse authResponse = authServiceClient.validateToken(authHeader);

        if(authResponse.getValid()){
            User user = userServiceClient.getUserById(request.getUserId());

            if(user != null) {
                Order order = new Order(orders.size() + 1, user.getId(), request.getProduct(), request.getAmount());
                orders.add(order);
                return ResponseEntity.status(HttpStatus.CREATED).body(order);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Exception("User not found"));
            }
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Exception("Invalid Token"));
        }

    }
}
