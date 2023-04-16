import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class CalculatorPositiveTest {

    @Test(timeout = 5000)
    @UseDataProvider("dataForAddTest")
    public void addTest(double a, double b, double result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(result, calculator.add(a, b), 0);
    }

    @Test(timeout = 5000)
    @UseDataProvider("dataForSubTest")
    public void subTest(double a, double b, double result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(result, calculator.sub(a, b), 0);
    }

    @Test(timeout = 5000)
    @UseDataProvider("dataForMulTest")
    public void mulTest(double a, double b, double result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(result, calculator.mul(a, b), 0);
    }

    @Test(timeout = 5000)
    @UseDataProvider("dataForDivTest")
    public void divTest(double a, double b, double result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(result, calculator.div(a, b), 0);
    }

    @Test(timeout = 5000)
    @UseDataProvider("dataForPowTest")
    public void powTest(double a, double b, double result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(result, calculator.pow(a, b), 0);
    }

    @Test(timeout = 5000)
    @UseDataProvider("dataForSqrtTest")
    public void sqrtTest(double a, double result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(result, calculator.sqrt(a), 0);
    }

    @Test(timeout = 5000)
    public void memoryTest() {
        Calculator calculator = new Calculator();
        calculator.add(2, 2); //memory == 4
        calculator.sub(2); //memory == 2
        calculator.mul(4); //memory == 8
        calculator.div(4); //memory == 2
        calculator.pow(4); //memory == 16
        Assert.assertEquals(4, calculator.sqrt(), 0);
    }


    @DataProvider
    public static Object[][] dataForAddTest() {
        return new Object[][] {
            {10, 20, 30},
            {-10, 20, 10},
            {10, -20, -10},
            {-10,-20, -30}
        };
    }

    @DataProvider
    public static Object[][] dataForSubTest() {
        return new Object[][] {
            {10, 20, -10},
            {-10, 20, -30},
            {10, -20, 30},
            {-10,-20, 10}
        };
    }

    @DataProvider
    public static Object[][] dataForMulTest() {
        return new Object[][] {
            {10, 20, 200},
            {-10, 20, -200},
            {10, -20, -200},
            {-10,-20, 200}
        };
    }

    @DataProvider
    public static Object[][] dataForDivTest() {
        return new Object[][] {
            {10, 20, 0.5},
            {-10, 20, -0.5},
            {10, -20, -0.5},
            {-10,-20, 0.5}
        };
    }

    @DataProvider
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

    @DataProvider
    public static Object[][] dataForSqrtTest() {
        return new Object[][] {
            {4, 2},
            {0, 0},
            {0.25, 0.5},
        };
    }
}
