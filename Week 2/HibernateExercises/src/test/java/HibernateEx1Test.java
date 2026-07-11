import com.deepskilling.hibernate.HibernateConfig;
import com.deepskilling.hibernate.entity.Employee;
import com.deepskilling.hibernate.repository.EmployeeRepository;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HibernateEx1Test {
    private SessionFactory sessionFactory;
    private EmployeeRepository empRepo;
    
    @Before
    public void setUp() {
        sessionFactory = HibernateConfig.getSessionFactory();
        empRepo = new EmployeeRepository(sessionFactory);
    }
    
    @Test
    public void testSaveEmployee() {
        Employee emp = new Employee("John Doe", "john@test.com", 75000, 1L);
        empRepo.saveEmployee(emp);
        assertNotNull(emp.getId());
    }
    
    @Test
    public void testFindEmployee() {
        Employee emp = new Employee("Jane Smith", "jane@test.com", 80000, 1L);
        empRepo.saveEmployee(emp);
        
        Employee found = empRepo.findById(emp.getId());
        assertNotNull(found);
        assertEquals("Jane Smith", found.getName());
    }
    
    @Test
    public void testUpdateEmployee() {
        Employee emp = new Employee("Alex Brown", "alex@test.com", 70000, 1L);
        empRepo.saveEmployee(emp);
        
        emp.setSalary(85000);
        empRepo.updateEmployee(emp);
        
        Employee updated = empRepo.findById(emp.getId());
        assertEquals(85000, updated.getSalary(), 0.01);
    }
    
    @Test
    public void testEmployeeSalaryValidation() {
        Employee emp = new Employee("Test User", "test@test.com", 95000, 1L);
        empRepo.saveEmployee(emp);
        
        Employee found = empRepo.findById(emp.getId());
        assertTrue(found.getSalary() > 90000);
    }
    
    @Test
    public void testMultipleEmployees() {
        Employee emp1 = new Employee("Emp1", "emp1@test.com", 75000, 1L);
        Employee emp2 = new Employee("Emp2", "emp2@test.com", 80000, 2L);
        
        empRepo.saveEmployee(emp1);
        empRepo.saveEmployee(emp2);
        
        assertNotNull(emp1.getId());
        assertNotNull(emp2.getId());
        assertNotEquals(emp1.getId(), emp2.getId());
    }
}