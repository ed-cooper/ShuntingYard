package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.BracketToken;
import net.edwardcooper.shuntingyard.model.ConstantToken;
import net.edwardcooper.shuntingyard.model.Token;
import org.junit.Assert;
import org.junit.Test;

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
        testReadToken("0", new ConstantToken("0", 0));
    }

    @Test
    public void testReadToken_1() {
        testReadToken("1", new ConstantToken("1", 1));
    }

    @Test
    public void testReadToken_2() {
        testReadToken("2", new ConstantToken("2", 2));
    }

    @Test
    public void testReadToken_3() {
        testReadToken("3", new ConstantToken("3", 3));
    }

    @Test
    public void testReadToken_4() {
        testReadToken("4", new ConstantToken("4", 4));
    }

    @Test
    public void testReadToken_5() {
        testReadToken("5", new ConstantToken("5", 5));
    }

    @Test
    public void testReadToken_6() {
        testReadToken("6", new ConstantToken("6", 6));
    }

    @Test
    public void testReadToken_7() {
        testReadToken("7", new ConstantToken("7", 7));
    }

    @Test
    public void testReadToken_8() {
        testReadToken("8", new ConstantToken("8", 8));
    }

    @Test
    public void testReadToken_9() {
        testReadToken("9", new ConstantToken("9", 9));
    }

    @Test
    public void testReadToken_1234567890() {
        testReadToken("1234567890", new ConstantToken("1234567890", 1234567890));
    }

    @Test
    public void testReadToken_123point45() {
        testReadToken("123.45", new ConstantToken("123.45", 123.45));
    }

    @Test
    public void testReadToken_e() {
        testReadToken("e", new ConstantToken("e", Math.E));
    }

    @Test
    public void testReadToken_pi() {
        testReadToken("π", new ConstantToken("π", Math.PI));
    }

    @Test
    public void testReadToken_pi_2() {
        testReadToken("pi", new ConstantToken("pi", Math.PI));
    }

    @Test
    public void testReadToken_leftParenthesis() {
        testReadToken("(", new BracketToken("(", true));
    }

    @Test
    public void testReadToken_rightParenthesis() {
        testReadToken(")", new BracketToken(")", false));
    }

    @Test
    public void testReadToken_leftBracket() {
        testReadToken("[", new BracketToken("[", true));
    }

    @Test
    public void testReadToken_rightBracket() {
        testReadToken("]", new BracketToken("]", false));
    }

    @Test
    public void testReadToken_leftBrace() {
        testReadToken("{", new BracketToken("{", true));
    }

    @Test
    public void testReadToken_rightBrace() {
        testReadToken("}", new BracketToken("}", false));
    }

    private void testReadToken(String token, Token expected) {
        // Don't test from first character, so that the start parameter is tested
        // Don't test until end, so that token termination is tested
        String input = "_" + token + "_";
        DefaultLexer lexer = new DefaultLexer();

        Token actual = lexer.readToken(input, 1);

        Assert.assertEquals(expected, actual);
    }
}
