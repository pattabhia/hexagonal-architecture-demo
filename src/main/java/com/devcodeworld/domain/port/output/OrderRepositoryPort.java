package com.devcodeworld.domain.port.output;

import com.devcodeworld.domain.dto.Order;

public interface OrderRepositoryPort {

    void saveOrder(Order order);
    String findById(String orderId);
}
