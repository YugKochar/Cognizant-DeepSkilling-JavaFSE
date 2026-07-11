import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    
    @Test
    public void testAllAssertions() {
        assertEquals(5, 2 + 3);
        assertEquals("Hello", "Hello");
        
        assertTrue(5 > 3);
        assertTrue("Test".startsWith("T"));
        
        assertFalse(5 < 3);
        assertFalse("Test".isEmpty());
        
        String nullValue = null;
        assertNull(nullValue);
        
        String notNull = "Hello";
        assertNotNull(notNull);
        
        Object obj = new Object();
        assertSame(obj, obj);
        
        assertNotSame(new Object(), new Object());
    }
    
    @Test
    public void testStringAssertions() {
        String actual = "Hello World";
        
        assertTrue(actual.contains("World"));
        assertEquals("Hello World", actual);
        assertNotNull(actual);
        assertEquals(11, actual.length());
    }
    
    @Test
    public void testNumberAssertions() {
        int number = 42;
        
        assertTrue(number > 0);
        assertTrue(number < 100);
        assertFalse(number < 0);
        assertEquals(42, number);
    }
    
    @Test
    public void testArrayAssertions() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testBooleanAssertions() {
        boolean isActive = true;
        boolean isDeleted = false;
        
        assertTrue(isActive);
        assertFalse(isDeleted);
    }
}