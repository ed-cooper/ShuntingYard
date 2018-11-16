package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    @Test
    public void getSymbol() {
        String expected = "+";
        Operator operator = new BinaryOperator(expected, 2, true,  (x, y) -> x + y);

        String actual = operator.getSymbol();

        Assert.assertEquals(expected, actual);
    }
}