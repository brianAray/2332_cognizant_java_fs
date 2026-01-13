package com.example.aop_demo.controller;

import com.example.aop_demo.controller.request.OrderRequest;
import com.example.aop_demo.controller.response.OrderResponse;
import com.example.aop_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Place new order
    @PostMapping()
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request){
        String orderId = orderService.placeOrder(
                request.getProductId(),
                request.getQuantity(),
                request.getCustomerId()
        );

        return ResponseEntity.ok(new OrderResponse(orderId, "Order placed successfully"));
    }
}
