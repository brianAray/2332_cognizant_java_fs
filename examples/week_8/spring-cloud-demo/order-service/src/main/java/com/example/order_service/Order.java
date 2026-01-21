package com.example.order_service;

public class Order {
    private Integer id;
    private Integer userId;
    private String product;
    private Float amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Order(Integer id, Integer userId, String product, Float amount) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }

    public Order() {
    }
}
