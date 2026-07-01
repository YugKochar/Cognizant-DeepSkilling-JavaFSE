import com.deepskilling.jpa.entity.Student;
import com.deepskilling.jpa.entity.Course;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.*;

public class JPAEx1Test {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-pu");
        em = emf.createEntityManager();
    }
    
    @Test
    public void testStudentPersist() {
        em.getTransaction().begin();
        Student student = new Student("Vinay Kumar", "vinay@deepskilling.com", 3.8);
        em.persist(student);
        em.getTransaction().commit();
        
        assertNotNull(student.getId());
    }
    
    @Test
    public void testCoursePersist() {
        em.getTransaction().begin();
        Course course = new Course("CS101", "Introduction to Java", 3);
        em.persist(course);
        em.getTransaction().commit();
        
        assertNotNull(course.getId());
    }
    
    @Test
    public void testStudentFind() {
        em.getTransaction().begin();
        Student student = new Student("Test User", "test@test.com", 3.5);
        em.persist(student);
        em.getTransaction().commit();
        
        Long studentId = student.getId();
        Student foundStudent = em.find(Student.class, studentId);
        assertNotNull(foundStudent);
        assertEquals("Test User", foundStudent.getName());
    }
    
    @Test
    public void testStudentUpdate() {
        em.getTransaction().begin();
        Student student = new Student("Old Name", "old@test.com", 3.0);
        em.persist(student);
        em.getTransaction().commit();
        
        Long studentId = student.getId();
        
        em.getTransaction().begin();
        Student foundStudent = em.find(Student.class, studentId);
        foundStudent.setName("New Name");
        foundStudent.setGpa(3.9);
        em.merge(foundStudent);
        em.getTransaction().commit();
        
        Student updatedStudent = em.find(Student.class, studentId);
        assertEquals("New Name", updatedStudent.getName());
        assertEquals(3.9, updatedStudent.getGpa(), 0.01);
    }
    
    @Test
    public void testStudentDelete() {
        em.getTransaction().begin();
        Student student = new Student("Delete Me", "delete@test.com", 2.5);
        em.persist(student);
        em.getTransaction().commit();
        
        Long studentId = student.getId();
        
        em.getTransaction().begin();
        Student foundStudent = em.find(Student.class, studentId);
        em.remove(foundStudent);
        em.getTransaction().commit();
        
        Student deletedStudent = em.find(Student.class, studentId);
        assertNull(deletedStudent);
    }
}