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

    @Override
    public boolean equals(Object obj) {
        // Check class is the same
        if (obj.getClass() != this.getClass()) return false;
        // Check literal is the same
        return this.getLiteral().equals(((Token)obj).getLiteral());
    }

    @Override
    public int hashCode() {
        // Tokens with the same literal should be equivalent, so use the hash code of the literal
        return this.literal.hashCode();
    }
}
