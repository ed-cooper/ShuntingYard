package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryOperatorTokenTest {

    @Test
    public void testGetOperation() {
        BinaryOperator expected = new BinaryOperator("+", 1, true, (x, y) -> x + y);
        BinaryOperatorToken token = new BinaryOperatorToken("+", expected);

        Operator actual = token.getOperation();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBinaryOperation() {
        BinaryOperator expected = new BinaryOperator("+", 1, true, (x, y) -> x + y);
        BinaryOperatorToken token = new BinaryOperatorToken("+", expected);

        BinaryOperator actual = token.getBinaryOperation();

        Assert.assertEquals(expected, actual);
    }
}