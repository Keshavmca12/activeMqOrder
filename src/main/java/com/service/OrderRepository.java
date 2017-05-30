package com.service;


import java.util.Map;

import com.model.Order;
 
public interface OrderRepository {
 
    public void putOrder(Order order);
     
    public Order getOrder(String orderId);
     
    public Map<String, Order> getAllOrders();
}
