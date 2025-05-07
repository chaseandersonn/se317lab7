package test.java.test;

import main.java.lab7main.CalculatorModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestModelOperations {
    private CalculatorModel model;

    @Before
    public void setUp() {
        model = new CalculatorModel();
    }

    @Test
    public void testAddition() {
        model.calculate(5, 3, "+");
        assertEquals(8.0, model.getResult(), 0.001);
    }

    @Test
    public void testSubtraction() {
        model.calculate(10, 4, "-");
        assertEquals(6.0, model.getResult(), 0.001);
    }

    @Test
    public void testMultiplication() {
        model.calculate(6, 7, "*");
        assertEquals(42.0, model.getResult(), 0.001);
    }

    @Test
    public void testDivision() {
        model.calculate(20, 4, "/");
        assertEquals(5.0, model.getResult(), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        model.calculate(20, 0, "/");
        assertTrue(Double.isNaN(model.getResult()));
    }

    @Test
    public void testSquare() {
        model.calculateSingle(5, "sqr");
        assertEquals(25.0, model.getResult(), 0.001);
    }

    @Test
    public void testSquareRoot() {
        model.calculateSingle(36, "sqrt");
        assertEquals(6.0, model.getResult(), 0.001);
    }

    @Test
    public void testSquareRootNegative() {
        model.calculateSingle(-9, "sqrt");
        assertTrue(Double.isNaN(model.getResult()));
    }

    @Test
    public void testMemoryAdd() {
        model.calculate(2, 2, "+"); // result = 4
        model.memoryAdd(3); // memory = 4 + 3
        assertEquals(7.0, model.getResult(), 0.001);
    }

    @Test
    public void testMemorySubtract() {
        model.calculate(10, 5, "+"); // result = 15
        model.memorySubtract(5); // result = 5 - 15 = -10
        assertEquals(-10.0, model.getResult(), 0.001);
    }

    @Test
    public void testMemoryRecall() {
        model.calculate(8, 2, "*"); // memory = 16
        assertEquals(16.0, model.memoryRecall(), 0.001);
    }

    @Test
    public void testMemoryClear() {
        model.calculate(1, 1, "+"); // memory = 2
        model.memoryClear();
        assertNull(model.memoryRecall());
    }
}
