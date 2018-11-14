package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.DoubleBinaryOperator;

public class BinaryOperatorTest {

    @Test
    public void testGetAction() {
        DoubleBinaryOperator expected = (x, y) -> x + y;
        BinaryOperator operator = new BinaryOperator("+", 1, true, expected);

        DoubleBinaryOperator actual = operator.getAction();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLeftAssociative_High() {
        boolean expected = true;
        BinaryOperator operator = new BinaryOperator("+", 1, expected, (x, y) -> x + y);

        boolean actual = operator.getLeftAssociative();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLeftAssociative_Low() {
        boolean expected = false;
        BinaryOperator operator = new BinaryOperator("+", 1, expected, (x, y) -> x + y);

        boolean actual = operator.getLeftAssociative();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrecedence() {
        int expected = 1;
        BinaryOperator operator = new BinaryOperator("+", expected, true, (x, y) -> x + y);

        int actual = operator.getPrecedence();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetToken() {
        BinaryOperator operator = new BinaryOperator("+", 1, true, (x, y) -> x + y);
        BinaryOperatorToken expected = new BinaryOperatorToken("+", operator);

        OperatorToken actual = operator.getToken();

        Assert.assertEquals(expected, actual);
    }
}