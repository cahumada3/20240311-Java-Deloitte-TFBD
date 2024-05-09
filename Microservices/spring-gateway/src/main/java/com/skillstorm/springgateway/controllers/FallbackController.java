package com.skillstorm.springgateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    
    @GetMapping("/cache/accounts")
    public String cachedAccounts() {
        return "Cached Account: courtesy of circuit breaker";
    }

    // @GetMapping("/cache/payments")
    // public String cachedPayments() {
    //     return "Cached Payments: courtesy of circuit breaker";
    // }
}
