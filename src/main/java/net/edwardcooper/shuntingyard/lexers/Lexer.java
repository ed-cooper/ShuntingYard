package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.Token;

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
}
