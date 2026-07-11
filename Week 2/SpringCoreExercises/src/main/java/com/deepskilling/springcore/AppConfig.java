package com.deepskilling.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public BankAccount bankAccount() {
        return new BankAccount("Vinay Kumar", 5000.0);
    }
    
    @Bean
    public PaymentService paymentService(BankAccount bankAccount) {
        return new PaymentService(bankAccount);
    }
    
    @Bean
    public EmailNotification emailNotification() {
        return new EmailNotification();
    }
}