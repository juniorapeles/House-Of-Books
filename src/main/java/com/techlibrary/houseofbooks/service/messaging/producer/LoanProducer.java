package com.techlibrary.houseofbooks.service.messaging.producer;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoanProducer {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public LoanProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Mensagem enviada: " + message);
    }

    public void send(LoanDTO dto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
        System.out.println("Pedido de Empréstimo feito: " + dto);
    }
}
