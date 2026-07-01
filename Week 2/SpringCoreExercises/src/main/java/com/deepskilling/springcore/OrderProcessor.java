package com.deepskilling.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    
    @Autowired
    private EmailNotification emailNotification;
    
    private String orderId;
    
    public void processOrder(String orderId, String customerEmail) {
        this.orderId = orderId;
        System.out.println("Processing order: " + orderId);
        emailNotification.sendEmail(customerEmail, "Order " + orderId + " received");
    }
    
    public String getOrderId() { return orderId; }
}