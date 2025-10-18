package com.devcodeworld.adapter.output;

import com.devcodeworld.adapter.output.entity.OrderEntity;
import com.devcodeworld.adapter.output.repository.SpringDataOrderRepository;
import com.devcodeworld.domain.dto.Order;
import com.devcodeworld.domain.port.output.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderRepository implements OrderRepositoryPort {

    @Autowired
    private SpringDataOrderRepository repository;

    @Override
    public void saveOrder(Order order) {
        System.out.println("--OUTPUT ADAPTER EXECUTED WITH OUTPUT PORT--");
        repository.save(mapToEntity(order));
    }
    @Override
    public String findById(String orderId) {
        OrderEntity entity = repository.findById(orderId).orElseThrow();
        System.out.println("--OUTPUT ADAPTER EXECUTED WITH OUTPUT PORT--");
        return mapToDomain(entity).getStatus();
    }

    private OrderEntity mapToEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(order.getOrderId());
        entity.setCustomerName(order.getCustomerName());
        entity.setRestaurantName(order.getRestaurantName());
        entity.setItem(order.getItem());
        entity.setStatus(order.getStatus());
        return entity;
    }

    private Order mapToDomain(OrderEntity entity) {
        Order order = new Order();
        order.setOrderId(entity.getOrderId());
        order.setCustomerName(entity.getCustomerName());
        order.setRestaurantName(entity.getRestaurantName());
        order.setItem(entity.getItem());
        order.setStatus(entity.getStatus());
        return order;
    }
}
