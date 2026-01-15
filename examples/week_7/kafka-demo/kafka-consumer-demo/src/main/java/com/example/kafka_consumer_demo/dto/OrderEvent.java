package com.example.kafka_consumer_demo.dto;

public class OrderEvent {
    private String orderId;
    private String name;
    private int quantity;

    @Override
    public String toString() {
        return "OrderEvent{" +
                "orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderEvent(String orderId, String name, int quantity) {
        this.orderId = orderId;
        this.name = name;
        this.quantity = quantity;
    }

    public OrderEvent() {
    }
}
