package net.edwardcooper.shuntingyard.parsers;

import net.edwardcooper.shuntingyard.model.InvalidSyntaxException;
import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.UnsupportedTokenException;

import java.util.List;

/**
 * Provides methods to convert an equation into RPN form.
 */
public interface Parser {
    /**
     * Parses an equation and returns the RPN form of it, expressed as a sequence of Tokens.
     * @param equation       The collection of tokens that represent the original equation.
     * @return               The RPN form of the input equation.
     */
    List<Token> parse(List<Token> equation) throws UnsupportedTokenException, InvalidSyntaxException;
}
