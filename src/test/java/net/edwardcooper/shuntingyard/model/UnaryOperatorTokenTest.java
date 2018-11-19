package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnaryOperatorTokenTest {

    @Test
    public void testGetOperation() {
        UnaryOperator expected = new UnaryOperator("sin", (x) -> Math.sin(x));
        UnaryOperatorToken token = new UnaryOperatorToken("sin", expected);

        Operator actual = token.getOperation();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUnaryOperation() {
        UnaryOperator expected = new UnaryOperator("sin", (x) -> Math.sin(x));
        UnaryOperatorToken token = new UnaryOperatorToken("sin", expected);

        UnaryOperator actual = token.getUnaryOperation();

        Assert.assertEquals(expected, actual);
    }
}