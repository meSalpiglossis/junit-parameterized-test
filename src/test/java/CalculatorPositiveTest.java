import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorPositiveTest {

    Calculator calculator;

    @BeforeEach
    @Timeout(5)
    public void setup() {
        calculator = new Calculator();
    }

    public static Object[][] dataForAddTest() {
        return new Object[][] {
            {10, 20, 30},
            {-10, 20, 10},
            {10, -20, -10},
            {-10,-20, -30}
        };
    }

    @ParameterizedTest
    @MethodSource("dataForAddTest")
    public void addTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.add(a, b), 0);
    }

    public static Object[][] dataForSubTest() {
        return new Object[][] {
            {10, 20, -10},
            {-10, 20, -30},
            {10, -20, 30},
            {-10,-20, 10}
        };
    }

    @ParameterizedTest
    @MethodSource("dataForSubTest")
    public void subTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.sub(a, b), 0);
    }

    public static Object[][] dataForMulTest() {
        return new Object[][] {
            {10, 20, 200},
            {-10, 20, -200},
            {10, -20, -200},
            {-10,-20, 200}
        };
    }

    @ParameterizedTest
    @MethodSource("dataForMulTest")
    public void mulTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.mul(a, b), 0);
    }

    public static Object[][] dataForDivTest() {
        return new Object[][] {
            {10, 20, 0.5},
            {-10, 20, -0.5},
            {10, -20, -0.5},
            {-10,-20, 0.5}
        };
    }

    @ParameterizedTest
    @MethodSource("dataForDivTest")
    public void divTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.div(a, b), 0);
    }

    public static Object[][] dataForPowTest() {
        return new Object[][] {
            {3, 2, 9},
            {4, 4, 256},
            {4, -1, 0.25},
            {-8, -2, 0.015625},
            {-8, 2, 64},
            {1000000000, 0, 1}
        };
    }

    @ParameterizedTest
    @MethodSource("dataForPowTest")
    public void powTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.pow(a, b), 0);
    }

    public static Object[][] dataForSqrtTest() {
        return new Object[][] {
            {4, 2},
            {0, 0},
            {0.25, 0.5},
        };
    }

    @ParameterizedTest
    @MethodSource("dataForSqrtTest")
    public void sqrtTest(double a, double result) {
        Assertions.assertEquals(result, calculator.sqrt(a), 0);
    }

    @Test()
    public void memoryTest() {
        calculator.add(2, 2); //memory == 4
        calculator.sub(2); //memory == 2
        calculator.mul(4); //memory == 8
        calculator.div(4); //memory == 2
        calculator.pow(4); //memory == 16
        Assertions.assertEquals(4, calculator.sqrt(), 0);
    }
}
