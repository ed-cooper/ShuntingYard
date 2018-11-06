package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for a multi-output unary operator in a mathematical expression.
 */
public class MultiOutputUnaryOperatorToken extends OperatorToken {
    private MultiOutputUnaryOperator operation;

    /**
     * MultiOutputUnaryOperatorToken class constructor.
     * @param literal       The string literal that this token represents.
     * @param operation     The operation that this token corresponds to.
     */
    public MultiOutputUnaryOperatorToken(String literal, MultiOutputUnaryOperator operation) {
        super(literal);

        this.operation = operation;
    }

    @Override
    public Operator getOperation() {
        return operation;
    }

    /**
     * Gets the multi-output unary operation that this token corresponds to.
     * @return              The multi-output unary operation that this token corresponds to.
     */
    public MultiOutputUnaryOperator getMultiOutputUnaryOperation() {
        return operation;
    }
}
