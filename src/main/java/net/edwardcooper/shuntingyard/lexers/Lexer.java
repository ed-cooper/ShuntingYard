package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.TokenNotRecognisedException;

import java.util.List;

/**
 * Provides methods to split an input string into a series of tokens.
 */
public interface Lexer {

    /**
     * Splits an input string into a series of tokens.
     * @param input         The input string to split.
     * @return              A list of <code>Token</code> objects representing the input string.
     */
    List<Token> readTokens(String input);

    /**
     * Reads a single token at the specified location within an input string.
     * @param input                         The input string to find a token within.
     * @param start                         The position of the first character of the token.
     * @return                              The token at the specified location within the input string.
     * @throws TokenNotRecognisedException  Thrown when a token could not be recognised.
     */
    Token readToken(String input, int start) throws TokenNotRecognisedException;
}
