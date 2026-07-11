import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final Logger logger = 
        LoggerFactory.getLogger(UserService.class);
    
    private List<String> users = new ArrayList<>();
    
    public void registerUser(String email) {
        logger.debug("Attempting to register user with email: {}", email);
        
        if (email == null || email.isEmpty()) {
            logger.error("User registration failed: Email is empty");
            throw new IllegalArgumentException("Email cannot be empty");
        }
        
        if (users.contains(email)) {
            logger.warn("User registration failed: Email already registered - {}", email);
            throw new IllegalArgumentException("Email already registered");
        }
        
        users.add(email);
        logger.info("User successfully registered: {}", email);
    }
    
    public void deleteUser(String email) {
        logger.debug("Attempting to delete user: {}", email);
        
        if (users.remove(email)) {
            logger.info("User successfully deleted: {}", email);
        } else {
            logger.warn("User not found for deletion: {}", email);
        }
    }
    
    public int getUserCount() {
        int count = users.size();
        logger.debug("Total users in system: {}", count);
        return count;
    }
}