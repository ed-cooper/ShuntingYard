package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for a variable in a mathematical expression whose value is only specified when evaluating the
 * expression.
 */
public class VariableToken extends Token {
    /**
     * VariableToken class constructor.
     * @param literal       The string literal that this token represents.
     */
    public VariableToken(String literal) {
        super(literal);
    }
}
