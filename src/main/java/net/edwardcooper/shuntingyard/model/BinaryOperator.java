package net.edwardcooper.shuntingyard.model;

import java.util.function.DoubleBinaryOperator;

public class BinaryOperator extends Operator {
    private final DoubleBinaryOperator action;
    private final boolean leftAssociative;
    private final int precedence;

    public BinaryOperator(String name, int precedence, boolean leftAssociative, DoubleBinaryOperator action) {
        super(name);

        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
        this.action = action;
    }

    public DoubleBinaryOperator getAction() {
        return action;
    }

    public boolean getLeftAssociative() {
        return leftAssociative;
    }

    public int getPrecedence() {
        return precedence;
    }
}
