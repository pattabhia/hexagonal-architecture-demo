package com.devcodeworld.adapter.input.rest;

import com.devcodeworld.domain.dto.Order;
import com.devcodeworld.domain.port.input.PlaceOrderUsecase;
import com.devcodeworld.domain.port.input.TrackOrderUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final PlaceOrderUsecase placeOrderUsecase;
    private final TrackOrderUsecase trackOrderUsecase;

    public OrderController(PlaceOrderUsecase placeOrderUsecase, TrackOrderUsecase trackOrderUsecase) {
        this.placeOrderUsecase = placeOrderUsecase;
        this.trackOrderUsecase = trackOrderUsecase;
    }
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        placeOrderUsecase.placeOrder(order);
        System.out.println("--INPUT ADAPTER EXECUTED--");
        return ResponseEntity.ok("Order placed");
    }

    @GetMapping("/track/{orderId}")
    public ResponseEntity<String> trackOrder(@PathVariable String orderId) {
        System.out.println("--INPUT ADAPTER EXECUTED--");
        return ResponseEntity.ok("Status: " + trackOrderUsecase.trackOrder(orderId));
    }
}
