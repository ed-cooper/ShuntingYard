package net.edwardcooper.shuntingyard.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class MultiOutputUnaryOperatorTest {

    @Test
    public void testGetAction() {
        Function<Double, List<Double>> expected = (x) -> Arrays.asList(x, -x);
        MultiOutputUnaryOperator operator = new MultiOutputUnaryOperator("±", expected);

        Function<Double, List<Double>> actual = operator.getAction();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetToken() {
        MultiOutputUnaryOperator operator = new MultiOutputUnaryOperator("±", (x) -> Arrays.asList(x, -x));
        MultiOutputUnaryOperatorToken expected = new MultiOutputUnaryOperatorToken(operator.getSymbol(), operator);

        OperatorToken actual = operator.getToken();

        Assert.assertEquals(expected, actual);
    }
}