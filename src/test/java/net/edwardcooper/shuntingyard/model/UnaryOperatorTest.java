package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.DoubleUnaryOperator;

import static org.junit.Assert.*;

public class UnaryOperatorTest {

    @Test
    public void testGetAction() {
        DoubleUnaryOperator expected = (x) -> Math.sin(x);
        UnaryOperator operator = new UnaryOperator("sin", expected);

        DoubleUnaryOperator actual = operator.getAction();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetToken() {
        UnaryOperator operator = new UnaryOperator("sin", (x) -> Math.sin(x));
        UnaryOperatorToken expected = new UnaryOperatorToken("sin", operator);

        OperatorToken actual = operator.getToken();

        Assert.assertEquals(expected, actual);
    }
}