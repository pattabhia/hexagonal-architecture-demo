package com.devcodeworld.adapter.output.repository;

import com.devcodeworld.domain.dto.Order;
import com.devcodeworld.domain.port.output.OrderRepositoryPort;

public class MongoOrderRepository implements OrderRepositoryPort {

    // inject mongo repository

    @Override
    public void saveOrder(Order order) {

    }

    @Override
    public String findById(String orderId) {
        return "";
    }
}
