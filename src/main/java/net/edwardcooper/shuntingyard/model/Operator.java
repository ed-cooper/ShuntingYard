package net.edwardcooper.shuntingyard.model;

/**
 * Represents an operator in a mathematical expression.
 */
public abstract class Operator {
    private final String symbol;

    /**
     * Operator class constructor.
     * @param symbol        The symbol of the operator being defined.
     */
    protected Operator(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the symbol of the operator defined by this instance.
     * @return              The symbol of the operator defined by this instance.
     */
    public String getSymbol() {
        return symbol;
    }
}
