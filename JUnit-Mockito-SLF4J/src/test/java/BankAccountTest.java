import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;
    
    @Before
    public void setUp() {
        System.out.println("⏳ Setting up test...");
        account = new BankAccount("Vinay", 1000.0);
    }
    
    @After
    public void tearDown() {
        System.out.println("✅ Cleaning up test...");
        account = null;
    }
    
    @Test
    public void testDeposit() {
        double depositAmount = 500.0;
        account.deposit(depositAmount);
        assertEquals(1500.0, account.getBalance(), 0.01);
    }
    
    @Test
    public void testWithdraw() {
        double withdrawAmount = 200.0;
        account.withdraw(withdrawAmount);
        assertEquals(800.0, account.getBalance(), 0.01);
    }
    
    @Test
    public void testInsufficientFunds() {
        double withdrawAmount = 2000.0;
        try {
            account.withdraw(withdrawAmount);
            fail("Should throw exception for insufficient funds");
        } catch (IllegalArgumentException e) {
            assertEquals("Insufficient funds", e.getMessage());
        }
    }
    
    @Test
    public void testTransfer() {
        BankAccount account2 = new BankAccount("Priya", 500.0);
        double transferAmount = 300.0;
        
        account.transfer(account2, transferAmount);
        
        assertEquals(700.0, account.getBalance(), 0.01);
        assertEquals(800.0, account2.getBalance(), 0.01);
    }
    
    @Test
    public void testInvalidDeposit() {
        try {
            account.deposit(-100);
            fail("Should throw exception for negative deposit");
        } catch (IllegalArgumentException e) {
            assertEquals("Deposit amount must be positive", e.getMessage());
        }
    }
}