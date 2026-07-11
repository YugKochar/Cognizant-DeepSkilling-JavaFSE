import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingIntegrationTest {
    private static final Logger logger = 
        LoggerFactory.getLogger(LoggingIntegrationTest.class);
    
    @Test
    public void testUserRegistrationLogging() {
        logger.info("Starting user registration test");
        
        UserService service = new UserService();
        
        try {
            logger.debug("Registering user: vinay@deepskilling.com");
            service.registerUser("vinay@deepskilling.com");
            logger.info("Test passed: User registered successfully");
        } catch (Exception e) {
            logger.error("Test failed with exception", e);
        }
    }
    
    @Test
    public void testDuplicateRegistration() {
        logger.info("Testing duplicate user registration");
        
        UserService service = new UserService();
        service.registerUser("user@example.com");
        
        try {
            logger.debug("Attempting duplicate registration");
            service.registerUser("user@example.com");
            logger.error("Test failed: Should have thrown exception");
        } catch (IllegalArgumentException e) {
            logger.warn("Expected exception caught: {}", e.getMessage());
            logger.info("Test passed: Duplicate registration prevented");
        }
    }
}