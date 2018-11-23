package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.model.InvalidSyntaxException;
import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.UnsupportedTokenException;

import java.util.List;

/**
 * Provides methods to evaluate an RPN equation.
 */
public interface Evaluator {
    /**
     * Evaluates the given RPN equation to produce a collection of output values.
     * @param equation          The equation to evaluate.
     * @return                  The collection of evluated output values.
     */
    List<Double> evaluate(List<Token> equation) throws UnsupportedTokenException, InvalidSyntaxException;
}
