package com.example.calculadora.Test;
import com.example.calculadora.Calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexis
 * @version 1.0
 * @since 1.0
 */
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testSum() throws Exception {
        int result = calculator.evaluate("2+3");
        Assert.assertEquals(5, result);
    }

    @Test
    public void testSubtract() throws Exception {
        int result = calculator.evaluate("5-3");
        Assert.assertEquals(2, result);
    }

    @Test
    public void testMultiply() throws Exception {
        int result = calculator.evaluate("2*3");
        Assert.assertEquals(6, result);
    }

    @Test
    public void testDivide() throws Exception {
        int result = calculator.evaluate("6/3");
        Assert.assertEquals(2, result);
    }

    @Test
    public void testComplexExpression() throws Exception {
        int result = calculator.evaluate("2*3+5-2");
        Assert.assertEquals(9, result);
    }

    @Test
    public void testMultipleMultiplications() throws Exception {
        int result = calculator.evaluate("2*3*4");
        Assert.assertEquals(24, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() throws Exception {
        calculator.evaluate("2/0");
    }
}

