package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for a binary operator in a mathematical expression.
 */
public class BinaryOperatorToken extends OperatorToken {
    private BinaryOperator operation;

    /**
     * BinaryOperatorToken class constructor.
     * @param literal       The string literal that this token represents.
     * @param operation     The operation that this token corresponds to.
     */
    public BinaryOperatorToken(String literal, BinaryOperator operation) {
        super(literal);

        this.operation = operation;
    }

    @Override
    public Operator getOperation() {
        return operation;
    }

    /**
     * Gets the binary operation that this token corresponds to.
     * @return              The binary operation that this token corresponds to.
     */
    public BinaryOperator getBinaryOperation() {
        return operation;
    }
}
