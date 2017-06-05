package com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.model.Order;
import com.service.OrderService;
 
 
@Controller
public class AppController {
 
    @Autowired
    OrderService orderService;
     
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String prepareProduct(ModelMap model) {
        return "index";
    }
 
    @RequestMapping(value = { "/newOrder" }, method = RequestMethod.GET)
    public String prepareOrder(ModelMap model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "order";
    }
 
    @RequestMapping(value = { "/newOrder" }, method = RequestMethod.POST)
    public String sendOrder(@Valid Order order, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "order";
        }
        orderService.sendOrder(order);
        model.addAttribute("success", "Order for " + order.getProductName() + " registered.");
        System.out.println("value "+model.get("success"));
        return "ordersuccess";
    }
     
    @RequestMapping(value = { "/checkStatus" }, method = RequestMethod.GET)
    public String checkOrderStatus(ModelMap model) {
        model.addAttribute("orders", orderService.getAllOrders());
        // create a new Gson instance
        Gson gson = new Gson();
        // convert your list to json
        String jsonOrderList = gson.toJson(orderService.getAllOrdersFromDataBase());
        // print your generated json
        System.out.println("jsonOrderList  : " + jsonOrderList);
        model.addAttribute("ordersDB", jsonOrderList);
        System.out.println("orderService.getAllOrdersFromDataBase()  "+orderService.getAllOrdersFromDataBase());
        return "orderStatus";
    }
}
