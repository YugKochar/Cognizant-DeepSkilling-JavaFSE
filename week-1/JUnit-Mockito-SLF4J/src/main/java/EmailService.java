import java.util.List;

public interface EmailService {
    void sendEmail(String recipient, String subject, String body);
    void sendBulkEmail(List<String> recipients, String subject, String body);
}