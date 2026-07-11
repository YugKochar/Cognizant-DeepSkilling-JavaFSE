import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    
    @Test
    public void testAddition() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }
    
    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }
    
    @Test
    public void testMultiplication() {
        int result = calculator.multiply(5, 4);
        assertEquals(20, result);
    }
    
    @Test
    public void testDivision() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }
}