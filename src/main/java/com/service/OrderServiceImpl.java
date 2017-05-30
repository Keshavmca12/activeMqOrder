package com.service;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messaging.MessageSender;
import com.model.InventoryResponse;
import com.model.Order;
import com.model.OrderStatus;
import com.util.BasicUtil;
 
 
@Service("orderService")
public class OrderServiceImpl implements OrderService{
 
    @Autowired
    MessageSender messageSender;
     
    @Autowired
    OrderRepository orderRepository;
     
    @Override
    public void sendOrder(Order order) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        order.setOrderId(BasicUtil.getUniqueId());
        order.setStatus(OrderStatus.CREATED);
        orderRepository.putOrder(order);
        System.out.println("Application : sending order request {}"+ order);
        messageSender.sendMessage(order);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
 
    @Override
    public void updateOrder(InventoryResponse response) {
         
        Order order = orderRepository.getOrder(response.getOrderId());
        if(response.getReturnCode()==200){
            order.setStatus(OrderStatus.CONFIRMED);
        }else if(response.getReturnCode()==300){
            order.setStatus(OrderStatus.FAILED);
        }else{
            order.setStatus(OrderStatus.PENDING);
        }
        orderRepository.putOrder(order);
    }
     
    public Map<String, Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }
 
}
