package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultLexerTest {

    @Test
    public void testReadTokens() {
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
    public void testReadToken_0() {
        testReadToken("0", new ConstantToken("0", 0), new DefaultLexer());
    }

    @Test
    public void testReadToken_1() {
        testReadToken("1", new ConstantToken("1", 1), new DefaultLexer());
    }

    @Test
    public void testReadToken_2() {
        testReadToken("2", new ConstantToken("2", 2), new DefaultLexer());
    }

    @Test
    public void testReadToken_3() {
        testReadToken("3", new ConstantToken("3", 3), new DefaultLexer());
    }

    @Test
    public void testReadToken_4() {
        testReadToken("4", new ConstantToken("4", 4), new DefaultLexer());
    }

    @Test
    public void testReadToken_5() {
        testReadToken("5", new ConstantToken("5", 5), new DefaultLexer());
    }

    @Test
    public void testReadToken_6() {
        testReadToken("6", new ConstantToken("6", 6), new DefaultLexer());
    }

    @Test
    public void testReadToken_7() {
        testReadToken("7", new ConstantToken("7", 7), new DefaultLexer());
    }

    @Test
    public void testReadToken_8() {
        testReadToken("8", new ConstantToken("8", 8), new DefaultLexer());
    }

    @Test
    public void testReadToken_9() {
        testReadToken("9", new ConstantToken("9", 9), new DefaultLexer());
    }

    @Test
    public void testReadToken_1234567890() {
        testReadToken("1234567890", new ConstantToken("1234567890", 1234567890), new DefaultLexer());
    }

    @Test
    public void testReadToken_123point45() {
        testReadToken("123.45", new ConstantToken("123.45", 123.45), new DefaultLexer());
    }

    @Test
    public void testReadToken_e() {
        testReadToken("e", new ConstantToken("e", Math.E), new DefaultLexer());
    }

    @Test
    public void testReadToken_pi() {
        testReadToken("π", new ConstantToken("π", Math.PI), new DefaultLexer());
    }

    @Test
    public void testReadToken_pi_2() {
        testReadToken("pi", new ConstantToken("pi", Math.PI), new DefaultLexer());
    }

    @Test
    public void testReadToken_leftParenthesis() {
        testReadToken("(", new BracketToken("(", true), new DefaultLexer());
    }

    @Test
    public void testReadToken_rightParenthesis() {
        testReadToken(")", new BracketToken(")", false), new DefaultLexer());
    }

    @Test
    public void testReadToken_leftBracket() {
        testReadToken("[", new BracketToken("[", true), new DefaultLexer());
    }

    @Test
    public void testReadToken_rightBracket() {
        testReadToken("]", new BracketToken("]", false), new DefaultLexer());
    }

    @Test
    public void testReadToken_leftBrace() {
        testReadToken("{", new BracketToken("{", true), new DefaultLexer());
    }

    @Test
    public void testReadToken_rightBrace() {
        testReadToken("}", new BracketToken("}", false), new DefaultLexer());
    }

    @Test
    public void testReadToken_plus() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("+", lexer.getOperators().get(0).getToken(), lexer);
    }

    @Test
    public void testReadToken_subtract() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("-", lexer.getOperators().get(1).getToken(), lexer);
    }

    @Test
    public void testReadToken_multiply() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("*", lexer.getOperators().get(2).getToken(), lexer);
    }

    @Test
    public void testReadToken_multiply_2() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("×", lexer.getOperators().get(3).getToken(), lexer);
    }

    @Test
    public void testReadToken_divide() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("/", lexer.getOperators().get(4).getToken(), lexer);
    }

    @Test
    public void testReadToken_divide_2() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("÷", lexer.getOperators().get(5).getToken(), lexer);
    }

    @Test
    public void testReadToken_power() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("^", lexer.getOperators().get(6).getToken(), lexer);
    }

    @Test
    public void testReadToken_negate() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("−", lexer.getOperators().get(7).getToken(), lexer);
    }

    @Test
    public void testReadToken_sqrt() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("sqrt", lexer.getOperators().get(8).getToken(), lexer);
    }

    @Test
    public void testReadToken_sqrt_2() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("√", lexer.getOperators().get(9).getToken(), lexer);
    }

    @Test
    public void testReadToken_sinh() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("sinh", lexer.getOperators().get(10).getToken(), lexer);
    }

    @Test
    public void testReadToken_cosh() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("cosh", lexer.getOperators().get(11).getToken(), lexer);
    }

    @Test
    public void testReadToken_tanh() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("tanh", lexer.getOperators().get(12).getToken(), lexer);
    }

    @Test
    public void testReadToken_sin() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("sin", lexer.getOperators().get(13).getToken(), lexer);
    }

    @Test
    public void testReadToken_cos() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("cos", lexer.getOperators().get(14).getToken(), lexer);
    }

    @Test
    public void testReadToken_tan() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("tan", lexer.getOperators().get(15).getToken(), lexer);
    }

    @Test
    public void testReadToken_asinh() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("asinh", lexer.getOperators().get(16).getToken(), lexer);
    }

    @Test
    public void testReadToken_acosh() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("acosh", lexer.getOperators().get(17).getToken(), lexer);
    }

    @Test
    public void testReadToken_atanh() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("atanh", lexer.getOperators().get(18).getToken(), lexer);
    }

    @Test
    public void testReadToken_asin() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("asin", lexer.getOperators().get(19).getToken(), lexer);
    }

    @Test
    public void testReadToken_arcsin() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("arcsin", lexer.getOperators().get(20).getToken(), lexer);
    }

    @Test
    public void testReadToken_acos() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("acos", lexer.getOperators().get(21).getToken(), lexer);
    }

    @Test
    public void testReadToken_arccos() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("arccos", lexer.getOperators().get(22).getToken(), lexer);
    }

    @Test
    public void testReadToken_atan() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("atan", lexer.getOperators().get(23).getToken(), lexer);
    }

    @Test
    public void testReadToken_arctan() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("arctan", lexer.getOperators().get(24).getToken(), lexer);
    }

    @Test
    public void testReadToken_log_10() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("log_10", lexer.getOperators().get(25).getToken(), lexer);
    }

    @Test
    public void testReadToken_log_2() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("log_2", lexer.getOperators().get(26).getToken(), lexer);
    }

    @Test
    public void testReadToken_ln() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("ln", lexer.getOperators().get(27).getToken(), lexer);
    }

    @Test
    public void testReadToken_plusMinus() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("±", lexer.getOperators().get(28).getToken(), lexer);
    }

    @Test
    public void testReadToken_minusPlus() {
        DefaultLexer lexer = new DefaultLexer();
        testReadToken("∓", lexer.getOperators().get(29).getToken(), lexer);
    }

    private void testReadToken(String token, Token expected, DefaultLexer lexer) {
        // Don't test from first character, so that the start parameter is tested
        // Don't test until end, so that token termination is tested
        String input = "_" + token + "_";

        Token actual = lexer.readToken(input, 1);

        Assert.assertEquals(expected, actual);
    }
}
