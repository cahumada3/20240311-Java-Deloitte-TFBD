package com.skillstorm.rabbitmqsubscriber.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    
    @Value("${exchanges.fanout}")
    private String fanoutExchangeName;

    @Value("${queues.fanout}")
    private String fanoutQueueName;

    // creating the exchange
    @Bean
    public Exchange fanoutExchange() {
        return new FanoutExchange(fanoutExchangeName);
    }

    // creating the queue
    @Bean
    public Queue queue() {
        return new Queue(fanoutQueueName);
    }

    // creating the binding between the queue and the exchange
    @Bean
    public Binding binding(FanoutExchange fanoutExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    // creating the message converter
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
