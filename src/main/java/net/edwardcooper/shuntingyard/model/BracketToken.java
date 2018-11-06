package net.edwardcooper.shuntingyard.model;

/**
 * Represents the token for a bracket in a mathematical expression.
 */
public class BracketToken extends Token {
    private boolean isOpenBracket;

    /**
     * BracketToken class constructor.
     * @param literal           The string literal that this token represents.
     * @param isOpenBracket     Whether this bracket is an open or a close bracket.
     */
    public BracketToken(String literal, boolean isOpenBracket) {
        super(literal);

        this.isOpenBracket = isOpenBracket;
    }

    /**
     * Gets whether this bracket is an open or a close bracket.
     * @return                  Whether this bracket is an open or a close bracket.
     */
    public boolean getIsOpenBracket() {
        return isOpenBracket;
    }
}
