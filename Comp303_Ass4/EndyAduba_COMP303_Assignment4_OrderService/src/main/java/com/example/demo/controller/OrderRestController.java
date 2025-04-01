package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;



@Controller
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String orderPage(Model model) {
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping("/order")
    public String placeOrder(@ModelAttribute Order order, Model model) {
        System.out.println("Received order: " + order);

        ResponseEntity<Order> response = orderService.placeOrder(order.getAccountId(), order.getStockSymbol(), order.getQuantity());

        if (response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("success", "Order placed successfully!");
        } else {
            model.addAttribute("error", "Failed to place order.");
        }

        return "order";
    }
}