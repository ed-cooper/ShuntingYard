package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.model.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return null;
    }


    /**
     * Gets the map of variable names to values.
     * @return              The map of variable names to values.
     */
    public Map<String, Integer> getVariables() {
        return variables;
    }
}
