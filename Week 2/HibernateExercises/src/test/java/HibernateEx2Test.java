import com.deepskilling.hibernate.HibernateConfig;
import com.deepskilling.hibernate.entity.Department;
import com.deepskilling.hibernate.entity.Project;
import com.deepskilling.hibernate.repository.DepartmentRepository;
import com.deepskilling.hibernate.repository.ProjectRepository;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HibernateEx2Test {
    private SessionFactory sessionFactory;
    private DepartmentRepository deptRepo;
    private ProjectRepository projRepo;
    
    @Before
    public void setUp() {
        sessionFactory = HibernateConfig.getSessionFactory();
        deptRepo = new DepartmentRepository(sessionFactory);
        projRepo = new ProjectRepository(sessionFactory);
    }
    
    @Test
    public void testSaveDepartment() {
        Department dept = new Department("Sales", "Chicago");
        deptRepo.saveDepartment(dept);
        assertNotNull(dept.getId());
    }
    
    @Test
    public void testFindDepartment() {
        Department dept = new Department("HR", "Boston");
        deptRepo.saveDepartment(dept);
        
        Department found = deptRepo.findById(dept.getId());
        assertNotNull(found);
        assertEquals("HR", found.getName());
    }
}