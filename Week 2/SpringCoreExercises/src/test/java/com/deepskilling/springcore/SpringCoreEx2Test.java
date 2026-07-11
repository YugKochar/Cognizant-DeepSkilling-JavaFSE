package com.deepskilling.springcore;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static org.junit.Assert.*;

@Configuration
@ComponentScan(basePackages = "com.deepskilling.springcore")
class TestConfig {
    @Bean
    public BankAccount bankAccount() {
        return new BankAccount("Test User", 10000);
    }
    
    @Bean
    public EmailNotification emailNotification() {
        return new EmailNotification();
    }
}

public class SpringCoreEx2Test {
    private AnnotationConfigApplicationContext context;
    
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(TestConfig.class);
    }
    
    @Test
    public void testOrderProcessorAutowiring() {
        OrderProcessor processor = context.getBean(OrderProcessor.class);
        assertNotNull(processor);
    }
    
    @Test
    public void testBankServiceAutowiring() {
        BankService bankService = context.getBean(BankService.class);
        assertNotNull(bankService);
    }
    
    @Test
    public void testOrderProcessing() {
        OrderProcessor processor = context.getBean(OrderProcessor.class);
        processor.processOrder("ORD-001", "customer@example.com");
        assertEquals("ORD-001", processor.getOrderId());
    }
    
    @Test
    public void testBankServiceTransfer() {
        BankService bankService = context.getBean(BankService.class);
        bankService.transferFunds(1000, "recipient@example.com");
        BankAccount account = context.getBean(BankAccount.class);
        assertEquals(9000.0, account.getBalance(), 0.01);
    }
    
    @Test
    public void testSingletonScope() {
        PaymentService service1 = context.getBean(PaymentService.class);
        PaymentService service2 = context.getBean(PaymentService.class);
        assertSame(service1, service2);
    }
}