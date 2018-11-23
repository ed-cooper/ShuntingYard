package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.lexers.DefaultLexer;
import net.edwardcooper.shuntingyard.model.ConstantToken;
import net.edwardcooper.shuntingyard.model.InvalidSyntaxException;
import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.UnsupportedTokenException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

public class DefaultEvaluatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEvaluate() throws UnsupportedTokenException, InvalidSyntaxException {
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

    @Test
    public void testEvaluate_UnexpectedTokenException_Operators()
            throws UnsupportedTokenException, InvalidSyntaxException {
        // Test equation 2 1 3 (i.e. missing operators)
        DefaultEvaluator evaluator = new DefaultEvaluator();
        List<Token> rpn = Arrays.asList(
                new ConstantToken("2", 2),  // 2
                new ConstantToken("1", 1),  // 1
                new ConstantToken("3", 3)   // 3
        );

        thrown.expect(InvalidSyntaxException.class);
        evaluator.evaluate(rpn);
    }

    @Test
    public void testEvaluate_UnexpectedTokenException_Operands()
            throws UnsupportedTokenException, InvalidSyntaxException {
        // Test equation * + (i.e. missing operands)
        DefaultLexer lexer = new DefaultLexer();
        DefaultEvaluator evaluator = new DefaultEvaluator();
        List<Token> rpn = Arrays.asList(
                lexer.getOperators().get(2).getToken(),  // *
                lexer.getOperators().get(0).getToken()   // +
        );

        thrown.expect(InvalidSyntaxException.class);
        evaluator.evaluate(rpn);
    }
}