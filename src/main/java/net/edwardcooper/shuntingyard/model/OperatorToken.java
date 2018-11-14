package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for an operator in a mathematical expression.
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

    @Override
    public boolean equals(Object obj) {
        // Check class is the same
        if (obj.getClass() != this.getClass()) return false;
        // Check other properties
        OperatorToken other = (OperatorToken)obj;
        return this.getLiteral().equals(other.getLiteral()) &&
                this.getOperation().equals(other.getOperation());
    }
}
