package net.edwardcooper.shuntingyard.model;

import java.util.function.BiFunction;

public class BinaryOperator extends Operator {
    protected BiFunction<Double, Double, Double> action;
    protected boolean leftAssociative;
    protected int precedence;

    public BinaryOperator(String name, int precedence, boolean leftAssociative, BiFunction<Double, Double, Double> action) {
        this.name = name;
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
