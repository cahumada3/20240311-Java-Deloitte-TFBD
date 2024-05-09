package com.skillstorm.rabbitmqpublisher.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Exchange;

@Configuration
public class RabbitMqConfig {

    /**
     * Can read from the environment using @Value and the ${} syntax
     *      @Value will inject the value into the parameter
     */
    @Value("${exchange.fanout}")
    private String fanoutExchangeName;

    /**
     * creating the FanoutExchnage
     *      you can name your beans if you have multiple exchanges to worry about
     *      then ask for those beans name using the @Qualifier 
     */

    @Bean
    public Exchange fanout() {
        return new FanoutExchange(fanoutExchangeName);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        /**
         * convert our java objects into json
         *      Jackson is a very common object mapper/converter
         * 
         * rabbitmq will use this implicitly
         */
        return new Jackson2JsonMessageConverter();
    }
    
}
