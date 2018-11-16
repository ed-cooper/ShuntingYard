package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTokenTest {

    @Test
    public void testEquals_true() {
        BinaryOperator operator = new BinaryOperator("+", 2, true,  (x, y) -> x + y);
        BinaryOperatorToken token1 = new BinaryOperatorToken("+", operator);
        BinaryOperatorToken token2 = new BinaryOperatorToken("+", operator);
        boolean expected = true;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_literal() {
        BinaryOperator operator = new BinaryOperator("+", 2, true,  (x, y) -> x + y);
        BinaryOperatorToken token1 = new BinaryOperatorToken("+", operator);
        BinaryOperatorToken token2 = new BinaryOperatorToken("-", operator);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_operator() {
        BinaryOperator operator1 = new BinaryOperator("+", 2, true,  (x, y) -> x + y);
        BinaryOperator operator2 = new BinaryOperator("-", 2, true,  (x, y) -> x - y);
        BinaryOperatorToken token1 = new BinaryOperatorToken("+", operator1);
        BinaryOperatorToken token2 = new BinaryOperatorToken("+", operator2);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }
}