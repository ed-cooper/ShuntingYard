package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultLexerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReadTokens() throws TokenNotRecognisedException {
        String equation = "±(2)+√e";
        DefaultLexer lexer = new DefaultLexer();
        List<Token> expected = Arrays.asList(
                lexer.getOperators().get(28).getToken(),                     // Plus-minus
                lexer.getBrackets().get(0),                                  // Left parenthesis
                new ConstantToken("2", 2),                      // 2
                lexer.getBrackets().get(1),                                  // Right parenthesis
                lexer.getOperators().get(0).getToken(),                      // +
                lexer.getOperators().get(9).getToken(),                      // Square root
                new ConstantToken("e", lexer.getConstants().get("e")) // e
        );

        List<Token> actual = lexer.readTokens(equation);

        boolean success = true;
        for (int i = 0; i < expected.size(); i++) {
            if (expected.get(i).getClass() != actual.get(i).getClass() ||
                !expected.get(i).getLiteral().equals(actual.get(i).getLiteral())) {
                success = false;
            }
        }

        Assert.assertEquals(true, success);
    }

    @Test
    public void testReadToken_0() throws TokenNotRecognisedException {
        testReadToken("0", new ConstantToken("0", 0), new DefaultLexer());
    }

    @Test
    public void testReadToken_1() throws TokenNotRecognisedException {
        testReadToken("1", new ConstantToken("1", 1), new DefaultLexer());
    }

    @Test
    public void testReadToken_2() throws TokenNotRecognisedException {
        testReadToken("2", new ConstantToken("2", 2), new DefaultLexer());
    }

    @Test
    public void testReadToken_3() throws TokenNotRecognisedException {
        testReadToken("3", new ConstantToken("3", 3), new DefaultLexer());
    }

    @Test
    public void testReadToken_4() throws TokenNotRecognisedException {
        testReadToken("4", new ConstantToken("4", 4), new DefaultLexer());
    }

    @Test
    public void testReadToken_5() throws TokenNotRecognisedException {
        testReadToken("5", new ConstantToken("5", 5), new DefaultLexer());
    }

    @Test
    public void testReadToken_6() throws TokenNotRecognisedException {
        testReadToken("6", new ConstantToken("6", 6), new DefaultLexer());
    }

    @Test
    public void testReadToken_7() throws TokenNotRecognisedException {
        testReadToken("7", new ConstantToken("7", 7), new DefaultLexer());
    }

    @Test
    public void testReadToken_8() throws TokenNotRecognisedException {
        testReadToken("8", new ConstantToken("8", 8), new DefaultLexer());
    }

    @Test
    public void testReadToken_9() throws TokenNotRecognisedException {
        testReadToken("9", new ConstantToken("9", 9), new DefaultLexer());
    }

    @Test
    public void testReadToken_1234567890() throws TokenNotRecognisedException {
        testReadToken("1234567890", new ConstantToken("1234567890", 1234567890), new DefaultLexer());
    }

    @Test
    public void testReadToken_123point45() throws TokenNotRecognisedException {
        testReadToken("123.45", new ConstantToken("123.45", 123.45), new DefaultLexer());
    }

    @Test
    public void testReadToken_123point() throws TokenNotRecognisedException {
        testReadToken("123.", new ConstantToken("123", 123), new DefaultLexer());
    }

    @Test
    public void testReadToken_e() throws TokenNotRecognisedException {
        testReadToken("e", new ConstantToken("e", Math.E), new DefaultLexer());
    }

    @Test
    public void testReadToken_pi() throws TokenNotRecognisedException {
        testReadToken("π", new ConstantToken("π", Math.PI), new DefaultLexer());
    }

    @Test
    public void testReadToken_pi_2() throws TokenNotRecognisedException {
        testReadToken("pi", new ConstantToken("pi", Math.PI), new DefaultLexer());
    }

    @Test
    public void testReadToken_leftParenthesis() throws TokenNotRecognisedException {
        testReadToken("(", new BracketToken("(", true), new DefaultLexer());
    }

    @Test
    public void testReadToken_rightParenthesis() throws TokenNotRecognisedException {
        testReadToken(")", new BracketToken(")", false), new DefaultLexer());
    }

    @Test
    public void testReadToken_leftBracket() throws TokenNotRecognisedException {
        testReadToken("[", new BracketToken("[", true), new DefaultLexer());
    }

    @Test
    public void testReadToken_rightBracket() throws TokenNotRecognisedException {
        testReadToken("]", new BracketToken("]", false), new DefaultLexer());
    }

    @Test
    public void testReadToken_leftBrace() throws TokenNotRecognisedException {
        testReadToken("{", new BracketToken("{", true), new DefaultLexer());
    }

    @Test
    public void testReadToken_rightBrace() throws TokenNotRecognisedException {
        testReadToken("}", new BracketToken("}", false), new DefaultLexer());
    }

    @Test
    public void testReadToken_plus() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("+", lexer.getOperators().get(0).getToken(), lexer);
    }

    @Test
    public void testReadToken_subtract() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("-", lexer.getOperators().get(1).getToken(), lexer);
    }

    @Test
    public void testReadToken_multiply() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("*", lexer.getOperators().get(2).getToken(), lexer);
    }

    @Test
    public void testReadToken_multiply_2() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("×", lexer.getOperators().get(3).getToken(), lexer);
    }

    @Test
    public void testReadToken_divide() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("/", lexer.getOperators().get(4).getToken(), lexer);
    }

    @Test
    public void testReadToken_divide_2() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("÷", lexer.getOperators().get(5).getToken(), lexer);
    }

    @Test
    public void testReadToken_power() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("^", lexer.getOperators().get(6).getToken(), lexer);
    }

    @Test
    public void testReadToken_negate() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("−", lexer.getOperators().get(7).getToken(), lexer);
    }

    @Test
    public void testReadToken_sqrt() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("sqrt", lexer.getOperators().get(8).getToken(), lexer);
    }

    @Test
    public void testReadToken_sqrt_2() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("√", lexer.getOperators().get(9).getToken(), lexer);
    }

    @Test
    public void testReadToken_sinh() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("sinh", lexer.getOperators().get(10).getToken(), lexer);
    }

    @Test
    public void testReadToken_cosh() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("cosh", lexer.getOperators().get(11).getToken(), lexer);
    }

    @Test
    public void testReadToken_tanh() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("tanh", lexer.getOperators().get(12).getToken(), lexer);
    }

    @Test
    public void testReadToken_sin() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("sin", lexer.getOperators().get(13).getToken(), lexer);
    }

    @Test
    public void testReadToken_cos() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("cos", lexer.getOperators().get(14).getToken(), lexer);
    }

    @Test
    public void testReadToken_tan() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("tan", lexer.getOperators().get(15).getToken(), lexer);
    }

    @Test
    public void testReadToken_asinh() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("asinh", lexer.getOperators().get(16).getToken(), lexer);
    }

    @Test
    public void testReadToken_acosh() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("acosh", lexer.getOperators().get(17).getToken(), lexer);
    }

    @Test
    public void testReadToken_atanh() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("atanh", lexer.getOperators().get(18).getToken(), lexer);
    }

    @Test
    public void testReadToken_asin() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("asin", lexer.getOperators().get(19).getToken(), lexer);
    }

    @Test
    public void testReadToken_arcsin() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("arcsin", lexer.getOperators().get(20).getToken(), lexer);
    }

    @Test
    public void testReadToken_acos() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("acos", lexer.getOperators().get(21).getToken(), lexer);
    }

    @Test
    public void testReadToken_arccos() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("arccos", lexer.getOperators().get(22).getToken(), lexer);
    }

    @Test
    public void testReadToken_atan() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("atan", lexer.getOperators().get(23).getToken(), lexer);
    }

    @Test
    public void testReadToken_arctan() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("arctan", lexer.getOperators().get(24).getToken(), lexer);
    }

    @Test
    public void testReadToken_log_10() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("log_10", lexer.getOperators().get(25).getToken(), lexer);
    }

    @Test
    public void testReadToken_log_2() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("log_2", lexer.getOperators().get(26).getToken(), lexer);
    }

    @Test
    public void testReadToken_ln() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("ln", lexer.getOperators().get(27).getToken(), lexer);
    }

    @Test
    public void testReadToken_plusMinus() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("±", lexer.getOperators().get(28).getToken(), lexer);
    }

    @Test
    public void testReadToken_minusPlus() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("∓", lexer.getOperators().get(29).getToken(), lexer);
    }

    @Test
    public void testReadToken_variable() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        lexer.getVariables().add("x");
        testReadToken("x", new VariableToken("x"), lexer);
    }

    @Test
    public void testReadToken_variable_2() throws TokenNotRecognisedException {
        DefaultLexer lexer = new DefaultLexer();
        lexer.getVariables().add("xyz");
        testReadToken("xyz", new VariableToken("xyz"), lexer);
    }

    @Test
    public void testReadToken_invalid() throws TokenNotRecognisedException {
        String input = "invalid";
        DefaultLexer lexer = new DefaultLexer();

        thrown.expect(TokenNotRecognisedException.class);
        lexer.readToken(input, 0);
    }

    private void testReadToken(String token, Token expected, DefaultLexer lexer) throws TokenNotRecognisedException {
        // Don't test from first character, so that the start parameter is tested
        // Don't test until end, so that token termination is tested
        String input = "_" + token + "_";

        Token actual = lexer.readToken(input, 1);

        Assert.assertEquals(expected, actual);
    }
}
