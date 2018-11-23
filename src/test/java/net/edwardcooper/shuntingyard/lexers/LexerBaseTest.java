package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.ConstantToken;
import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.TokenNotRecognisedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class LexerBaseTest {

    @Test
    public void testReadTokens() throws TokenNotRecognisedException {
        LexerBase lexer = new LexerBase() {
            @Override
            public Token readToken(String input, int start) throws TokenNotRecognisedException {
                // Detect only constant tokens for simple example

                // Create set of constants
                HashMap<String, Double> constants = new HashMap<String, Double>();
                constants.put("a",   10d);
                constants.put("bcd", 20d);
                constants.put("ff",  30d);

                // Check input string against each known constant
                for (String constant : constants.keySet()) {
                    if (input.startsWith(constant, start)) {
                        return new ConstantToken(constant, constants.get(constant));
                    }
                }

                // Token not recognised
                throw new TokenNotRecognisedException(input, start);
            }
        };
        String input = "aabcdff";
        List<Token> expected = Arrays.asList(
                new ConstantToken("a", 10d),
                new ConstantToken("a", 10d),
                new ConstantToken("bcd", 20d),
                new ConstantToken("ff", 30d)
        );

        List<Token> actual = lexer.readTokens(input);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testPreprocess() {
        LexerBase lexer = new LexerBase() {
            @Override
            public Token readToken(String input, int start) throws TokenNotRecognisedException {
                throw new TokenNotRecognisedException(input, start);
            }
        };
        String input = "a + b";
        String expected = input;

        String actual = lexer.preprocess(input);

        Assert.assertEquals(expected, actual);
    }
}