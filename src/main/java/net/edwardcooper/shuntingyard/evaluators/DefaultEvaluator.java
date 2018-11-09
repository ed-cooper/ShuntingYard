package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.model.Token;

import java.util.*;

/**
 * The default evaluator for evaluating maths expressions.
 *
 * The supported input token types of this class are: <code>OperatorToken</code>, <code>ConstantToken</code>,
 * <code>VariableToken</code>.
 */
public class DefaultEvaluator extends EvaluatorBase {
    private HashMap<String, Integer> variables = new HashMap<>();

    @Override
    public List<Double> evaluate(List<Token> equation) {
        // If RPN empty, return no result
        if (equation.isEmpty()) {
            return Collections.emptyList();
        }

        // Create stack to hold intermediary values
        Stack<List<Double>> values = new Stack<>();

        // For each RPN token
        for (Token token : equation) {

        }

        // There should be a single item remaining in values - the final output
        if (values.size() > 1) {
            // TODO: create class for exception
            throw new RuntimeException("Invalid RPN");
        }

        return values.pop();
    }


    /**
     * Gets the map of variable names to values.
     * @return              The map of variable names to values.
     */
    public Map<String, Integer> getVariables() {
        return variables;
    }
}
