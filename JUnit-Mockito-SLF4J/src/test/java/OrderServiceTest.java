import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.InOrder;
import java.util.Arrays;
import java.util.List;

public class OrderServiceTest {
    
    @Test
    public void testVerifyInteraction() {
        EmailService mockEmailService = mock(EmailService.class);
        OrderService service = new OrderService(mockEmailService);
        
        service.placeOrder("customer@email.com", "ORD-001");
        
        verify(mockEmailService)
            .sendEmail(
                "customer@email.com",
                "Order Confirmation",
                "Your order ORD-001 has been confirmed"
            );
    }
    
    @Test
    public void testVerifyInteractionCalledOnce() {
        EmailService mockEmailService = mock(EmailService.class);
        OrderService service = new OrderService(mockEmailService);
        
        service.placeOrder("user@email.com", "ORD-002");
        
        verify(mockEmailService, times(1))
            .sendEmail(anyString(), anyString(), anyString());
    }
    
    @Test
    public void testVerifyInteractionCalledNever() {
        EmailService mockEmailService = mock(EmailService.class);
        OrderService service = new OrderService(mockEmailService);
        
        verify(mockEmailService, never())
            .sendEmail(anyString(), anyString(), anyString());
    }
    
    @Test
    public void testVerifyBulkEmailInteraction() {
        EmailService mockEmailService = mock(EmailService.class);
        OrderService service = new OrderService(mockEmailService);
        
        List<String> recipients = Arrays.asList(
            "user1@email.com",
            "user2@email.com",
            "user3@email.com"
        );
        
        service.notifyCustomers(recipients, "New offers available!");
        
        verify(mockEmailService)
            .sendBulkEmail(recipients, "Notification", "New offers available!");
    }
    
    @Test
    public void testVerifyCallOrder() {
        EmailService mockEmailService = mock(EmailService.class);
        OrderService service = new OrderService(mockEmailService);
        
        service.placeOrder("user@email.com", "ORD-001");
        service.placeOrder("user2@email.com", "ORD-002");
        
        InOrder inOrder = inOrder(mockEmailService);
        inOrder.verify(mockEmailService)
            .sendEmail("user@email.com", "Order Confirmation", 
                       "Your order ORD-001 has been confirmed");
        inOrder.verify(mockEmailService)
            .sendEmail("user2@email.com", "Order Confirmation", 
                       "Your order ORD-002 has been confirmed");
    }
}