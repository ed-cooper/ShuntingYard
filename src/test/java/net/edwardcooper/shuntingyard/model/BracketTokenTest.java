package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BracketTokenTest {

    @Test
    public void testGetIsOpenBracket_true() {
        boolean expected = true;
        BracketToken token = new BracketToken("(", expected);

        boolean actual = token.getIsOpenBracket();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIsOpenBracket_false() {
        boolean expected = false;
        BracketToken token = new BracketToken(")", expected);

        boolean actual = token.getIsOpenBracket();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_true() {
        BracketToken token1 = new BracketToken("(", true);
        BracketToken token2 = new BracketToken("(", true);
        boolean expected = true;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_literal() {
        BracketToken token1 = new BracketToken("(", true);
        BracketToken token2 = new BracketToken("[", true);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals_false_isOpenBracket() {
        BracketToken token1 = new BracketToken("(", true);
        BracketToken token2 = new BracketToken("(", false);
        boolean expected = false;

        boolean actual = token1.equals(token2);

        Assert.assertEquals(expected, actual);
    }
}