package net.edwardcooper.shuntingyard.model;

import java.util.function.DoubleUnaryOperator;

/**
 * Represents an operator in a mathematical expression that accepts 1 input and produces 1 output.
 */
public class UnaryOperator extends Operator {
    private final DoubleUnaryOperator action;

    /**
     * UnaryOperator class constructor.
     * @param symbol        The symbol of the operator being defined.
     * @param action        The function of the operator which maps an input value to an output value.
     */
    public UnaryOperator(String symbol, DoubleUnaryOperator action) {
        super(symbol);

        this.action = action;
    }

    /**
     * Gets the function of the operator defined by this instance, which maps an input value to an output value.
     * @return              The function of the operator defined by this instance, which maps an input value to an
     *                      output value.
     */
    public DoubleUnaryOperator getAction() {
        return action;
    }

    @Override
    public OperatorToken getToken() {
        return new UnaryOperatorToken(getSymbol(), this);
    }
}
