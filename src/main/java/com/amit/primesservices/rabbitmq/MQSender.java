package com.amit.primesservices.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@AllArgsConstructor
public class MQSender {

    private final Queue queue;
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String username, int n, boolean isPrime) {
        String message = MessageFormat.format(
                "customer: {0}, n: {1}, isPrime: {2}"
                , username, String.valueOf(n), isPrime);
        message = "{" + message + "}";
        rabbitTemplate.convertAndSend("primes", message);
    }

}
