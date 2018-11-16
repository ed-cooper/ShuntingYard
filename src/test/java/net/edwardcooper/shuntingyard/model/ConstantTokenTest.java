package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantTokenTest {

    @Test
    public void testGetValue() {
        double expected = 27;
        ConstantToken token = new ConstantToken("a", expected);

        double actual = token.getValue();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testEquals_true() {
        ConstantToken token1 = new ConstantToken("a", 1);
        ConstantToken token2 = new ConstantToken("a", 1);
        boolean expected = true;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_literal() {
        ConstantToken token1 = new ConstantToken("a", 1);
        ConstantToken token2 = new ConstantToken("b", 1);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_value() {
        ConstantToken token1 = new ConstantToken("a", 1);
        ConstantToken token2 = new ConstantToken("a", 2);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }
}