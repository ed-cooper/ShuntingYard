package net.edwardcooper.shuntingyard.model;

import java.util.function.DoubleBinaryOperator;

/**
 * Represents an operator in a mathematical expression that accepts 2 inputs and produces 1 output.
 */
public class BinaryOperator extends Operator {
    private final DoubleBinaryOperator action;
    private final boolean leftAssociative;
    private final int precedence;

    /**
     * BinaryOperator class constructor.
     * @param name              The name of the operator being defined.
     * @param precedence        The precedence of the operator, where a higher value causes the operator to be evaluated
     *                          before operators with a lower precedence.
     * @param leftAssociative   Whether the operator is left or right associative.
     * @param action            The function of the operator, which maps 2 input values to an output value.
     */
    public BinaryOperator(String name, int precedence, boolean leftAssociative, DoubleBinaryOperator action) {
        super(name);

        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
        this.action = action;
    }

    /**
     * Gets the function of the operator, which maps 2 input values to an output value.
     * @return                  The function of the operator, which maps 2 input values to an output value.
     */
    public DoubleBinaryOperator getAction() {
        return action;
    }

    /**
     * Gets whether the operator is left or right associative.
     * @return                  Whether the operator is left or right associative.
     */
    public boolean getLeftAssociative() {
        return leftAssociative;
    }

    /**
     * Gets the precedence of the operator, where a higher value causes the operator to be evaluated before operators
     * with a lower precedence.
     * @return                  The precedence of the operator, where a higher value causes the operator to be evaluated
     *                          before operators with a lower precedence.
     */
    public int getPrecedence() {
        return precedence;
    }
}
