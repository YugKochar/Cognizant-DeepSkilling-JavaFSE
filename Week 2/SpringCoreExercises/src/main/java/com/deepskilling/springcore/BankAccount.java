package com.deepskilling.springcore;

public class BankAccount {
    private String accountHolder;
    private double balance;
    
    public BankAccount() {}
    
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        this.balance -= amount;
    }
    
    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
}