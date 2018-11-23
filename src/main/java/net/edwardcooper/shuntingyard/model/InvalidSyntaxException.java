package net.edwardcooper.shuntingyard.model;

/**
 * Thrown to indicate that the input equation did not have valid syntax.
 */
public class InvalidSyntaxException extends Exception {
    /**
     * InvalidSyntaxException class constructor.
     */
    public InvalidSyntaxException(String message) {
        super(message);
    }
}
