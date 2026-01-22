package com.example.order_service;

public class OrderRequest {
    private Integer userId;
    private String product;
    private Float amount;

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

    public OrderRequest(Integer userId, String product, Float amount) {
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }

    public OrderRequest() {
    }
}
