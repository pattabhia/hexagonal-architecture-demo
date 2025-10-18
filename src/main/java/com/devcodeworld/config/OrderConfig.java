package com.devcodeworld.config;

import com.devcodeworld.domain.port.output.OrderRepositoryPort;
import com.devcodeworld.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderService orderService(OrderRepositoryPort repository) {
        return new OrderService(repository);
    }
}
