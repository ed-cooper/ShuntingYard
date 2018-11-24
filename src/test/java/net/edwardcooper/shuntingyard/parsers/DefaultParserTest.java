package net.edwardcooper.shuntingyard.parsers;

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

public class DefaultParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testParse() throws UnsupportedTokenException, InvalidSyntaxException {
        // Test equation: ±(2)+√e
        DefaultLexer lexer = new DefaultLexer();
        DefaultParser parser = new DefaultParser();
        List<Token> tokens = Arrays.asList(
                lexer.getOperators().get(28).getToken(),                     // Plus-minus
                lexer.getBrackets().get(0),                                  // Left parenthesis
                new ConstantToken("2", 2),                      // 2
                lexer.getBrackets().get(1),                                  // Right parenthesis
                lexer.getOperators().get(0).getToken(),                      // +
                lexer.getOperators().get(9).getToken(),                      // Square root
                new ConstantToken("e", lexer.getConstants().get("e")) // e
        );
        List<Token> expected = Arrays.asList(
                tokens.get(2), // 2
                tokens.get(0), // Plus-minus
                tokens.get(6), // e
                tokens.get(5), // Square root
                tokens.get(4)  // +
        );

        List<Token> actual = parser.parse(tokens);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParse_BinaryOperators() throws UnsupportedTokenException, InvalidSyntaxException {
        // Test equation: 4+2*3-6/5^1
        DefaultLexer lexer = new DefaultLexer();
        DefaultParser parser = new DefaultParser();
        List<Token> tokens = Arrays.asList(
                new ConstantToken("4", 4), // 4
                lexer.getOperators().get(0).getToken(), // +
                new ConstantToken("2", 2), // 2
                lexer.getOperators().get(2).getToken(), // *
                new ConstantToken("3", 3), // 3
                lexer.getOperators().get(1).getToken(), // -
                new ConstantToken("6", 6), // 6
                lexer.getOperators().get(4).getToken(), // /
                new ConstantToken("5", 5), // 5
                lexer.getOperators().get(6).getToken(), // ^
                new ConstantToken("1", 5)  // 1
        );
        List<Token> expected = Arrays.asList(
                tokens.get(0),  // 4
                tokens.get(2),  // 2
                tokens.get(4),  // 3
                tokens.get(3),  // *
                tokens.get(1),  // +
                tokens.get(6),  // 6
                tokens.get(8),  // 5
                tokens.get(10), // 1
                tokens.get(9),  // ^
                tokens.get(7),  // /
                tokens.get(5)   // -
        );

        List<Token> actual = parser.parse(tokens);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParse_Brackets() throws UnsupportedTokenException, InvalidSyntaxException {
        // Test equation: 4+(2*(3-6)/5)^1
        DefaultLexer lexer = new DefaultLexer();
        DefaultParser parser = new DefaultParser();
        List<Token> tokens = Arrays.asList(
                new ConstantToken("4", 4), // 4
                lexer.getOperators().get(0).getToken(), // +
                lexer.getBrackets().get(0),             // (
                new ConstantToken("2", 2), // 2
                lexer.getOperators().get(2).getToken(), // *
                lexer.getBrackets().get(0),             // (
                new ConstantToken("3", 3), // 3
                lexer.getOperators().get(1).getToken(), // -
                new ConstantToken("6", 6), // 6
                lexer.getBrackets().get(1),             // )
                lexer.getOperators().get(4).getToken(), // /
                new ConstantToken("5", 5), // 5
                lexer.getBrackets().get(1),             // )
                lexer.getOperators().get(6).getToken(), // ^
                new ConstantToken("1", 5)  // 1
        );
        List<Token> expected = Arrays.asList(
                tokens.get(0),  // 4
                tokens.get(3),  // 2
                tokens.get(6),  // 3
                tokens.get(8),  // 6
                tokens.get(7),  // -
                tokens.get(4),  // *
                tokens.get(11), // 5
                tokens.get(10), // /
                tokens.get(14), // 1
                tokens.get(13), // ^
                tokens.get(1)   // +
        );

        List<Token> actual = parser.parse(tokens);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParse_InvalidSyntaxException() throws UnsupportedTokenException, InvalidSyntaxException  {
        // Test equation: ± +
        DefaultLexer lexer = new DefaultLexer();
        DefaultParser parser = new DefaultParser();
        List<Token> tokens = Arrays.asList(
                lexer.getOperators().get(28).getToken(), // ±
                lexer.getOperators().get(0).getToken()   // +
        );

        thrown.expect(InvalidSyntaxException.class);
        parser.parse(tokens);
    }

}
