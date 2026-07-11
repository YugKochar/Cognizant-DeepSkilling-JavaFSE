import com.deepskilling.jpa.entity.Student;
import com.deepskilling.jpa.entity.Course;
import com.deepskilling.jpa.entity.Enrollment;
import com.deepskilling.jpa.service.EnrollmentService;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.*;

public class JPAEx2Test {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EnrollmentService enrollmentService;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-pu");
        em = emf.createEntityManager();
        enrollmentService = new EnrollmentService(em);
    }
    
    @Test
    public void testEnrollmentCreation() {
        em.getTransaction().begin();
        Student student = new Student("Vinay", "vinay@test.com", 3.8);
        Course course = new Course("CS101", "Java", 3);
        em.persist(student);
        em.persist(course);
        em.getTransaction().commit();
        
        enrollmentService.enrollStudentInCourse(student.getId(), course.getId(), "2026-06-27");
        
        Enrollment enrollment = em.createQuery(
            "SELECT e FROM Enrollment e WHERE e.studentId = :sid AND e.courseId = :cid",
            Enrollment.class
        ).setParameter("sid", student.getId())
         .setParameter("cid", course.getId())
         .getSingleResult();
        
        assertNotNull(enrollment);
    }
    
    @Test
    public void testUpdateGrade() {
        em.getTransaction().begin();
        Student student = new Student("Test", "test@test.com", 3.5);
        Course course = new Course("CS102", "Database", 3);
        em.persist(student);
        em.persist(course);
        em.getTransaction().commit();
        
        enrollmentService.enrollStudentInCourse(student.getId(), course.getId(), "2026-06-27");
        
        Enrollment enrollment = em.createQuery(
            "SELECT e FROM Enrollment e WHERE e.studentId = :sid",
            Enrollment.class
        ).setParameter("sid", student.getId())
         .getSingleResult();
        
        enrollmentService.updateGrade(enrollment.getId(), "A");
        
        Enrollment updated = em.find(Enrollment.class, enrollment.getId());
        assertEquals("A", updated.getGrade());
    }
    
    @Test
    public void testMultipleEnrollments() {
        em.getTransaction().begin();
        Student student = new Student("Multi", "multi@test.com", 3.6);
        Course course1 = new Course("CS103", "Web Dev", 3);
        Course course2 = new Course("CS104", "Mobile", 3);
        em.persist(student);
        em.persist(course1);
        em.persist(course2);
        em.getTransaction().commit();
        
        enrollmentService.enrollStudentInCourse(student.getId(), course1.getId(), "2026-06-27");
        enrollmentService.enrollStudentInCourse(student.getId(), course2.getId(), "2026-06-27");
        
        Long count = em.createQuery(
            "SELECT COUNT(e) FROM Enrollment e WHERE e.studentId = :sid",
            Long.class
        ).setParameter("sid", student.getId())
         .getSingleResult();
        
        assertEquals(2L, count.longValue());
    }
    
    @Test
    public void testEnrollmentPersist() {
        em.getTransaction().begin();
        Enrollment enrollment = new Enrollment(1L, 1L, "2026-06-27");
        em.persist(enrollment);
        em.getTransaction().commit();
        
        assertNotNull(enrollment.getId());
    }
    
    @Test
    public void testEnrollmentFind() {
        em.getTransaction().begin();
        Enrollment enrollment = new Enrollment(1L, 1L, "2026-06-27");
        em.persist(enrollment);
        em.getTransaction().commit();
        
        Long enrollmentId = enrollment.getId();
        Enrollment found = em.find(Enrollment.class, enrollmentId);
        assertNotNull(found);
        assertEquals("2026-06-27", found.getEnrollmentDate());
    }
}