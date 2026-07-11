package com.deepskilling.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    
    @Autowired
    private EmailNotification emailNotification;
    
    @Autowired
    private BankAccount bankAccount;
    
    public void transferFunds(double amount, String recipientEmail) {
        bankAccount.withdraw(amount);
        emailNotification.sendEmail(recipientEmail, "Received $" + amount);
    }
}