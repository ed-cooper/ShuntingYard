package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.lexers.DefaultLexer;
import net.edwardcooper.shuntingyard.model.ConstantToken;
import net.edwardcooper.shuntingyard.model.Token;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DefaultEvaluatorTest {

    @Test
    public void testEvaluate() {
        // Test equation ±(2+1*3)+√(2^2)
        DefaultLexer lexer = new DefaultLexer();
        DefaultEvaluator evaluator = new DefaultEvaluator();
        List<Token> rpn = Arrays.asList(
                new ConstantToken("2", 2),  // 2
                new ConstantToken("1", 1),  // 1
                new ConstantToken("3", 3),  // 3
                lexer.getOperators().get(2).getToken(),  // *
                lexer.getOperators().get(0).getToken(),  // +
                lexer.getOperators().get(28).getToken(), // ±
                new ConstantToken("2", 2),  // 2
                new ConstantToken("2", 2),  // 2
                lexer.getOperators().get(6).getToken(),  // ^
                lexer.getOperators().get(9).getToken(),  // √
                lexer.getOperators().get(0).getToken()   // +
        );
        List<Double> expected = Arrays.asList(7d, -3d);

        List<Double> actual = evaluator.evaluate(rpn);

        Assert.assertEquals(expected, actual);
    }
}