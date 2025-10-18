package com.devcodeworld.adapter.input.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.devcodeworld.domain.dto.Order;
import com.devcodeworld.domain.port.input.PlaceOrderUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaConsumer {

    @Autowired
    private PlaceOrderUsecase placeOrderUseCase;

    //@KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consume(String message) throws JsonProcessingException {
        // Assuming the message is a JSON string representing an Order
        // For simplicity, let's assume the message is directly convertible
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(message, Order.class);
        placeOrderUseCase.placeOrder(order);
        System.out.println("Order placed via Kafka");
    }

}
