import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;

import java.security.InvalidParameterException;

public class CalculatorNegativeTest {

    Calculator calculator;

    @BeforeEach
    @Timeout(5)
    public void setup() {
        calculator = new Calculator();
    }



    @Test()
    public void divideBy0Test() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            calculator.div(1, 0);
        });
    }


    @Test() //expected = InvalidParameterException.class
    public void sqrtNegativeNumberTest() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            calculator.sqrt(-1);
        });


    }

}
