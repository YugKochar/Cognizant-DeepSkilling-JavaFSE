import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = 
        LoggerFactory.getLogger(LoggingExample.class);
    
    public static void main(String[] args) {
        logger.debug("Application started");
        
        demonstrateLogLevels();
        demonstrateParameterizedLogging();
        demonstrateExceptionLogging();
    }
    
    public static void demonstrateLogLevels() {
        logger.info("========== LOG LEVELS DEMO ==========");
        
        logger.trace("This is a TRACE message - most detailed");
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
    }
    
    public static void demonstrateParameterizedLogging() {
        logger.info("========== PARAMETERIZED LOGGING DEMO ==========");
        
        String userName = "Vinay";
        int orderId = 12345;
        double amount = 4999.99;
        
        logger.info("User {} placed order #{} for amount: ₹{}", 
                    userName, orderId, amount);
        
        String operation = "User Registration";
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        logger.debug("Operation {} completed in {} ms", operation, duration);
    }
    
    public static void demonstrateExceptionLogging() {
        logger.info("========== EXCEPTION LOGGING DEMO ==========");
        
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An arithmetic error occurred", e);
            logger.warn("Error: {}", e.getMessage());
        }
    }
}