package com.deepskilling.springcore;

public class PaymentService {
    private BankAccount bankAccount;
    
    // Constructor Injection
    public PaymentService(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    public boolean processPayment(double amount) {
        try {
            bankAccount.withdraw(amount);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    public double getAccountBalance() {
        return bankAccount.getBalance();
    }
}