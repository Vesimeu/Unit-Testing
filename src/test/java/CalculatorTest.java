import org.testng.Assert;
import org.testng.annotations.Test;
import com.yourdomain.unit_testing.Calculator;

public class CalculatorTest {

    @Test
    public void testAdd() {
        // Arrange
        double a = 5;
        double b = 3;
    
        // Act
        double result = Calculator.add(a, b);
    
        // Assert
        Assert.assertEquals(result, 8.0, "The addition result is incorrect.");
    }

    @Test
    public void testSubtract() {
        // Arrange
        double a = 5;
        double b = 3;
    
        // Act
        double result = Calculator.subtract(a, b);
    
        // Assert
        Assert.assertEquals(result, 2.0, "The subtraction result is incorrect.");
    }

    @Test
    public void testMultiply() {
        // Arrange
        double a = 5;
        double b = 3;
    
        // Act
        double result = Calculator.multiply(a, b);
    
        // Assert
        Assert.assertEquals(result, 15.0, "The multiplication result is incorrect.");
    }

    @Test
    public void testDivide() {
        // Arrange
        double a = 10;
        double b = 2;
    
        // Act
        double result = Calculator.divide(a, b);
    
        // Assert
        Assert.assertEquals(result, 5.0, "The division result is incorrect.");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        // Arrange
        double a = 10;
        double b = 0;
    
        // Act
        Calculator.divide(a, b);
    }
}
