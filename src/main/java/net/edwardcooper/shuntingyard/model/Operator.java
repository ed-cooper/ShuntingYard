package net.edwardcooper.shuntingyard.model;

/**
 * Represents an operator in a mathematical expression.
 */
public abstract class Operator {
    private final String name;

    /**
     * Operator class constructor.
     * @param name      The name of the operator being defined.
     */
    protected Operator(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the operator defined by this instance.
     * @return          The name of the operator defined by this instance.
     */
    public String getName() {
        return name;
    }
}
