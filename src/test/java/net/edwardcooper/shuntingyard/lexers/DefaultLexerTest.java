package net.edwardcooper.shuntingyard.lexers;

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
                lexer.getOperators().get(28).getToken(), // Plus-minus
                lexer.getBrackets().get(0), // Left parenthesis
                new ConstantToken("2", 2), // 2
                lexer.getBrackets().get(1), // Right parenthesis
                lexer.getOperators().get(0).getToken(), // +
                lexer.getOperators().get(9).getToken(), // Square root
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
}
