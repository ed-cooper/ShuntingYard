package net.edwardcooper.shuntingyard.model;

import java.util.function.DoubleUnaryOperator;

public class UnaryOperator extends Operator {
    private final DoubleUnaryOperator action;

    public UnaryOperator(String name, DoubleUnaryOperator action) {
        super(name);

        this.action = action;
    }

    public DoubleUnaryOperator getAction() {
        return action;
    }
}
