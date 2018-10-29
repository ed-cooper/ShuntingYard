package net.edwardcooper.shuntingyard.model;

abstract public class Operator {
    private String name;

    protected Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
