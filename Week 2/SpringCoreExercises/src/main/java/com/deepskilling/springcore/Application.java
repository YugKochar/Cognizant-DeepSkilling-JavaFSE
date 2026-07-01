package com.deepskilling.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        PaymentService paymentService = context.getBean(PaymentService.class);
        System.out.println("Initial balance: " + paymentService.getAccountBalance());
        
        paymentService.processPayment(500);
        System.out.println("After payment: " + paymentService.getAccountBalance());
        
        context.close();
    }
}