package net.edwardcooper.shuntingyard.model;

import java.util.List;
import java.util.function.Function;

/**
 * Represents an operator in a mathematical expression that accepts 1 input and produces multiple outputs.
 */
public class MultiOutputUnaryOperator extends Operator {
    private final Function<Double, List<Double>> action;

    /**
     * MultiOutputUnaryOperator class constructor.
     * @param symbol        The symbol of the operator being defined.
     * @param action        The function of the operator which maps an input value to several output values.
     */
    public MultiOutputUnaryOperator(String symbol, Function<Double, List<Double>> action) {
        super(symbol);

        this.action = action;
    }

    /**
     * Gets the function of the operator defined by this instance, which maps an input value to a several output values.
     * @return              The function of the operator defined by this instance, which maps an input value to several
     *                      output values.
     */
    public Function<Double, List<Double>> getAction() {
        return action;
    }
}
