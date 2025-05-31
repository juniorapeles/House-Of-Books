package com.techlibrary.houseofbooks.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${queue.loan}")
    private String queue;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    @Bean
    public Queue loanQueue() {
        return new Queue(queue, true);
    }

    @Bean
    public DirectExchange loanExchange() {
        return new DirectExchange(exchange);
    }


    @Bean
    public Binding loanBinding() {
        return BindingBuilder
                .bind(loanQueue())
                .to(loanExchange())
                .with(routingKey);
    }
}
