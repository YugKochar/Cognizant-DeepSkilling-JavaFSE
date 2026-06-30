public class BankAccount {
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
    }
    
    public void transfer(BankAccount recipient, double amount) {
        this.withdraw(amount);
        recipient.deposit(amount);
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
}