package com.electronic.store.services;

import java.util.List;

import com.electronic.store.dtos.CreateOrderRequest;
import com.electronic.store.dtos.OrderDto;
import com.electronic.store.dtos.OrderUpdateRequest;

public interface OrderService {

    // Create a new order
    OrderDto createOrder(CreateOrderRequest orderDto);

    // Delete an order
    void removeOrder(String orderId);

    // Get all orders of a specific user
    List<OrderDto> getOrdersOfUser(String userId);

    // Get all orders (admin or general listing)
    List<OrderDto> getAllOrders();

    // Update an existing order
    OrderDto updateOrder(String orderId, OrderUpdateRequest request);
}