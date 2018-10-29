package net.edwardcooper.shuntingyard.model;

import java.util.function.Function;

public class UnaryOperator extends Operator {
    private final Function<Double, Double> action;

    public UnaryOperator(String name, Function<Double, Double> action) {
        super(name);

        this.action = action;
    }

    public Function<Double, Double> getAction() {
        return action;
    }
}
