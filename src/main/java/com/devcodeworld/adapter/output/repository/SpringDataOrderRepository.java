package com.devcodeworld.adapter.output.repository;

import com.devcodeworld.adapter.output.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, String> {
}
