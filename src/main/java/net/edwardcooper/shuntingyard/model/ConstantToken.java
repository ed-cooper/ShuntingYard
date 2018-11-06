package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for a numerical value or other constant in a mathematical expression.
 */
public class ConstantToken extends Token {
    private double value;

    /**
     * ConstantToken class constructor.
     * @param literal       The string literal that this token represents.
     * @param value         The actual value represented by the token.
     */
    public ConstantToken(String literal, double value) {
        super(literal);

        this.value = value;
    }

    /**
     * Gets the actual value represented by the token.
     * @return              The actual value represented by this token.
     */
    public double getValue() {
        return value;
    }
}
