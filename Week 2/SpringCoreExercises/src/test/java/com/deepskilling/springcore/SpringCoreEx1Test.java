package com.deepskilling.springcore;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

public class SpringCoreEx1Test {
    private AnnotationConfigApplicationContext context;
    private PaymentService paymentService;
    
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        paymentService = context.getBean(PaymentService.class);
    }
    
    @Test
    public void testPaymentServiceExists() {
        assertNotNull(paymentService);
    }
    
    @Test
    public void testBankAccountInjection() {
        assertEquals(5000.0, paymentService.getAccountBalance(), 0.01);
    }
    
    @Test
    public void testProcessPayment() {
        boolean result = paymentService.processPayment(1000);
        assertTrue(result);
        assertEquals(4000.0, paymentService.getAccountBalance(), 0.01);
    }
    
    @Test
    public void testInsufficientFunds() {
        boolean result = paymentService.processPayment(10000);
        assertFalse(result);
    }
    
    @Test
    public void testMultiplePayments() {
        paymentService.processPayment(500);
        paymentService.processPayment(300);
        assertEquals(4200.0, paymentService.getAccountBalance(), 0.01);
    }
}