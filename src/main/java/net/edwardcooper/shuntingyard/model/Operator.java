package net.edwardcooper.shuntingyard.model;

public abstract class Operator {
    private final String name;

    protected Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
