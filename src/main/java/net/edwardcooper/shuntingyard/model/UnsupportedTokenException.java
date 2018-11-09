package net.edwardcooper.shuntingyard.model;

import java.util.List;

/**
 * Thrown to indicate that an unsupported token type was found whilst parsing or evaluating an equation.
 */
public class UnsupportedTokenException extends RuntimeException {
    private List<Token> equation;
    private Token token;

    /**
     * UnsupportedTokenException class constructor.
     * @param equation          The equation containing the unsupported token.
     * @param token             The token which was not supported.
     */
    public UnsupportedTokenException(List<Token> equation, Token token) {
        super("Unsupported token \"" + token.getLiteral() + " of type " + token.getClass().getSimpleName());

        this.equation = equation;
        this.token = token;
    }

    /**
     * Gets the equation containing the unsupported token.
     * @return                  The equation containing the unsupported token.
     */
    public List<Token> getEquation() {
        return equation;
    }

    /**
     * Gets the token which was not supported.
     * @return                  The token which was not supported.
     */
    public Token getToken() {
        return token;
    }
}
