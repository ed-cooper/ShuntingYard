package net.edwardcooper.shuntingyard.model;

import java.util.function.BiFunction;

public class BinaryOperator extends Operator {
    private final BiFunction<Double, Double, Double> action;
    private final boolean leftAssociative;
    private final int precedence;

    public BinaryOperator(String name, int precedence, boolean leftAssociative, BiFunction<Double, Double, Double> action) {
        super(name);

        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
        this.action = action;
    }

    public BiFunction<Double, Double, Double> getAction() {
        return action;
    }

    public boolean getLeftAssociative() {
        return leftAssociative;
    }

    public int getPrecedence() {
        return precedence;
    }
}
