package com.example.order_service;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", path = "auth")
public interface AuthServiceClient {

    @GetMapping
    AuthResponse validateToken(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
}
