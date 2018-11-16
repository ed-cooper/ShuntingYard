package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MultiOutputUnaryOperatorTokenTest {

    @Test
    public void testGetOperation() {
        MultiOutputUnaryOperator expected = new MultiOutputUnaryOperator("±", (x) -> Arrays.asList(x, -x));
        MultiOutputUnaryOperatorToken token = new MultiOutputUnaryOperatorToken("±", expected);

        Operator actual = token.getOperation();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMultiOutputUnaryOperation() {
        MultiOutputUnaryOperator expected = new MultiOutputUnaryOperator("±", (x) -> Arrays.asList(x, -x));
        MultiOutputUnaryOperatorToken token = new MultiOutputUnaryOperatorToken("±", expected);

        MultiOutputUnaryOperator actual = token.getMultiOutputUnaryOperation();

        Assert.assertEquals(expected, actual);
    }

}