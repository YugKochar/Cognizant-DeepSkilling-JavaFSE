import java.util.List;

public class OrderService {
    private EmailService emailService;
    
    public OrderService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    public void placeOrder(String customerEmail, String orderId) {
        System.out.println("Order " + orderId + " placed");
        
        emailService.sendEmail(
            customerEmail, 
            "Order Confirmation", 
            "Your order " + orderId + " has been confirmed"
        );
    }
    
    public void notifyCustomers(List<String> emails, String message) {
        emailService.sendBulkEmail(emails, "Notification", message);
    }
}