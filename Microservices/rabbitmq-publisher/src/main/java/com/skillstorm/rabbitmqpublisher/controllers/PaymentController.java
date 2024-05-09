package com.skillstorm.rabbitmqpublisher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.rabbitmqpublisher.services.PaymentService;

@RestController
@RequestMapping("/publisher")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment")
    public void payments(@RequestParam String username, @RequestParam double amount) {
        paymentService.processPayment(username, amount);
    }
    
}
