import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Tells Spring to read our configuration file and set up the objects
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Request the fully managed BookService from Spring
        BookService bookService = context.getBean("bookService", BookService.class);

        // Test it out!
        System.out.println("Books in Library: " + bookService.getLibraryBooks());
    }
}