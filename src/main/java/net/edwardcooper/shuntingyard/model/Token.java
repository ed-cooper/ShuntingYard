package net.edwardcooper.shuntingyard.model;

/**
 * Represents a single element within an equation.
 */
public abstract class Token {
    private String literal;

    /**
     * Token class constructor.
     * @param literal       The string literal that this token represents.
     */
    protected Token(String literal) {
        this.literal = literal;
    }

    /**
     * Gets the string literal that this token represents.
     * @return              The string literal that this token represents.
     */
    public String getLiteral() {
        return literal;
    }
}
