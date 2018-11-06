package net.edwardcooper.shuntingyard.model;

/**
 * Thrown to indicate that a token was not recognised whilst tokenising a string.
 */
public class TokenNotRecognisedException extends RuntimeException {
    private String inputString;
    private int position;

    /**
     * TokenNotRecognisedException class constructor.
     * @param inputString       The input string being tokenised.
     * @param position          The start position of the unrecognised token.
     */
    public TokenNotRecognisedException(String inputString, int position) {
        super("Unrecognised token at char " + position + " in \"" + inputString + "\"");

        this.inputString = inputString;
        this.position = position;
    }

    /**
     * Gets the input string being tokenised.
     * @return                  The input string being tokenised.
     */
    public String getInputString() {
        return inputString;
    }

    /**
     * Gets the start position of the unrecognised token.
     * @return                  The start position of the unrecognised token.
     */
    public int getPosition() {
        return position;
    }
}
