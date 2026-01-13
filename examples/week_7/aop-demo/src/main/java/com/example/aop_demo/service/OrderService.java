package com.example.aop_demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {

    private final Random random = new Random();

    // Place an order
    public String placeOrder(String productId, int quantity, String customerId){
        // business login
        simulateProcessingTime();

        String orderId = "ORD-" + System.currentTimeMillis();
        return orderId;
    }

    private void simulateProcessingTime(){
        try{
            Thread.sleep(random.nextInt(200) + 50);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
