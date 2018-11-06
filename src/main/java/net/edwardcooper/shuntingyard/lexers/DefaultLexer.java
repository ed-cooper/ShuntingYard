package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.TokenNotRecognisedException;

import java.lang.reflect.Type;

/**
 * The default lexer for tokenising maths expressions.
 */
public class DefaultLexer extends LexerBase {
    @Override
    public Token readToken(String input, int start) throws TokenNotRecognisedException {
        throw new TokenNotRecognisedException(input, start);
    }

    @Override
    public Type[] getSupportedOutputTokenTypes() {
        return new Type[] {};
    }
}
