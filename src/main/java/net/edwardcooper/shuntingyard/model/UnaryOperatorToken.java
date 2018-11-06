package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for a unary operator in a mathematical expression.
 */
public class UnaryOperatorToken extends OperatorToken {
    private UnaryOperator operation;

    /**
     * UnaryOperatorToken class constructor.
     * @param literal       The string literal that this token represents.
     * @param operation     The operation that this token corresponds to.
     */
    public UnaryOperatorToken(String literal, UnaryOperator operation) {
        super(literal);

        this.operation = operation;
    }

    @Override
    public Operator getOperation() {
        return operation;
    }

    /**
     * Gets the unary operation that this token corresponds to.
     * @return              The unary operation that this token corresponds to.
     */
    public UnaryOperator getUnaryOperation() {
        return operation;
    }
}
