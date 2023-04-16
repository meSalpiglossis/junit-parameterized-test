import org.junit.Test;

import java.security.InvalidParameterException;

public class CalculatorNegativeTest {

    @Test(timeout = 5000, expected = InvalidParameterException.class)
    public void divideBy0Test() {
        Calculator calculator = new Calculator();
        calculator.div(1, 0);
    }


    @Test(timeout = 5000, expected = InvalidParameterException.class)
    public void sqrtNegativeNumberTest() {
        Calculator calculator = new Calculator();
        calculator.sqrt(-1);
    }

}
