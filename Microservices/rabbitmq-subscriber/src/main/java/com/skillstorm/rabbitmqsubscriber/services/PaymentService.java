package com.skillstorm.rabbitmqsubscriber.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.skillstorm.rabbitmqsubscriber.dtos.PaymentDto;

@Service
public class PaymentService {
    
    /**
     * RabbitListener can be used to listen/read for messages
     *      sets the following method to run when a message is read from the given queue
     * 
     * Payload will get the data out of our queue
     */
    @RabbitListener(queues = "${queues.fanout}")
    public void recievePaymentInfo(@Payload PaymentDto paymentInfo) {
        System.out.println("Payment Username: " + paymentInfo.getUsername());
        System.out.println("Payment Amount: " + paymentInfo.getAmount());
    }
}
