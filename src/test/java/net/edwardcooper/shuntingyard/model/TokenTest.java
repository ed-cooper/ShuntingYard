package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenTest {

    @Test
    public void testGetLiteral() {
        String expected = "x";
        Token token = new VariableToken(expected);

        String actual = token.getLiteral();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_true() {
        // Use VariableToken as this does not override equals
        Token token1 = new VariableToken("x");
        Token token2 = new VariableToken("x");
        boolean expected = true;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_literal() {
        // Use VariableToken as this does not override equals
        Token token1 = new VariableToken("x");
        Token token2 = new VariableToken("y");
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_class() {
        // Use equals method on VariableToken as this does not override equals
        Token token1 = new VariableToken("x");
        Token token2 = new ConstantToken("x", 10);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        Token token1 = new VariableToken("x");
        Token token2 = new VariableToken("y");

        int unexpected = token1.hashCode();
        int actual = token2.hashCode();

        Assert.assertNotEquals(unexpected, actual);
    }
}