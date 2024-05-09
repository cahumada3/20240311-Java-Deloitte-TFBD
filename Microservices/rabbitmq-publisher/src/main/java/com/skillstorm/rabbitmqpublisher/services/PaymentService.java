package com.skillstorm.rabbitmqpublisher.services;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.skillstorm.rabbitmqpublisher.dtos.PaymentDto;

@Service
public class PaymentService {

    /**
     * RabbitTemplate is used to write messages to the exchange
     *      it is based on the template design pattern
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange fanoutExchange;

    @Value("${routing-key}")
    private String routingKey;
    
    public void processPayment(String username, double amount) {
        /**
         * convert and send will convert our objects into json and then into a rabbitmq message
         *      then it will add to the exchange with routingKey
         */
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), routingKey, new PaymentDto(username, amount));

    }
}
