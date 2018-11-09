package net.edwardcooper.shuntingyard.model;

import java.util.List;

/**
 * Thrown to indicate that an unsupported token type was found whilst parsing an equation.
 */
public class UnsupportedTokenException extends RuntimeException {
    private List<Token> equation;
    private int index;

    /**
     * UnsupportedTokenException class constructor.
     * @param equation          The equation containing the unsupported token.
     * @param index             The index of the unsupported token in the equation,
     */
    public UnsupportedTokenException(List<Token> equation, int index) {
        super("Unsupported token type at index " + index + " in equation");

        this.equation = equation;
        this.index = index;
    }

    /**
     * Gets the equation containing the unsupported token.
     * @return                  The equation containing the unsupported token.
     */
    public List<Token> getEquation() {
        return equation;
    }

    /**
     * Gets the index of the unsupported token in the equation.
     * @return                  The index of the unsupported token in the equation.
     */
    public int getIndex() {
        return index;
    }
}
