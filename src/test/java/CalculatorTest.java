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
}
