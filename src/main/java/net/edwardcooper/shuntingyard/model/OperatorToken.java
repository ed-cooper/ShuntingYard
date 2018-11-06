package net.edwardcooper.shuntingyard.model;

/**
 * Represents an operator in a mathematical expression.
 */
public abstract class OperatorToken extends Token {

    /**
     * OperatorToken class constructor.
     * @param literal       The string literal that this token represents.
     */
    protected OperatorToken(String literal) {
        super(literal);
    }

    /**
     * Gets the operation that this token corresponds to.
     * @return              The operation that this token corresponds to.
     */
    public abstract Operator getOperation();
}
