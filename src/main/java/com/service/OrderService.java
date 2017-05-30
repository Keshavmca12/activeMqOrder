package com.service;

import java.util.Map;

import com.model.InventoryResponse;
import com.model.Order;

 
public interface OrderService {
    public void sendOrder(Order order);
     
    public void updateOrder(InventoryResponse response);
     
    public Map<String, Order> getAllOrders();
}