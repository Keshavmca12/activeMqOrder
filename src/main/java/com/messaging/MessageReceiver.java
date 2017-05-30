package com.messaging;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.model.InventoryResponse;
import com.service.OrderService;

@Component
public class MessageReceiver {
 
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";
     
    @Autowired
    OrderService orderService;
     
     
    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<InventoryResponse> message) throws JMSException {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        System.out.println("Application : headers received : {}"+ headers);
         
        InventoryResponse response = message.getPayload();
        System.out.println("Application : response received : {}"+response);
         
        orderService.updateOrder(response); 
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
