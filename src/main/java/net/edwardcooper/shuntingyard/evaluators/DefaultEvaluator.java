package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.model.*;

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
            if (token instanceof BinaryOperatorToken) { // Binary ops
                evaluateBinaryOperator((BinaryOperatorToken) token, values);
            } else if (token instanceof UnaryOperatorToken) { // Unary ops
                evaluateUnaryOperator((UnaryOperatorToken) token, values);
            } else if (token instanceof ConstantToken) { // Constant
                evaluateConstantToken((ConstantToken) token, values);
            } else {
                throw new UnsupportedTokenException(equation, token);
            }
        }

        // There should be a single item remaining in values - the final output
        if (values.size() > 1) {
            // TODO: create class for exception
            throw new RuntimeException("Invalid RPN");
        }

        return values.pop();
    }

    /**
     * Evaluates a binary operator token.
     * @param token         The current token being evaluated.
     * @param values        The current stack of intermediary values.
     */
    protected void evaluateBinaryOperator(BinaryOperatorToken token, Stack<List<Double>> values) {
        // Get operands
        List<Double> operand2 = values.pop();
        List<Double> operand1 = values.pop();

        // Get cartesian product of operands, for all possible combinations of inputs
        List<Double[]> cartesian = this.cartesian(operand1, operand2);

        // Get outputs
        ArrayList<Double> outputs = new ArrayList<>();
        for (Double[] pair : cartesian) {
            // Get output for each pair of operands
            outputs.add(token.getBinaryOperation().getAction().applyAsDouble(pair[0], pair[1]));
        }

        // Push outputs to stack
        values.push(outputs);
    }

    /**
     * Evaluates a unary operator token.
     * @param token         The current token being evaluated.
     * @param values        The current stack of intermediary values.
     */
    protected void evaluateUnaryOperator(UnaryOperatorToken token, Stack<List<Double>> values) {
        // Get operands
        List<Double> operand1 = values.pop();

        // Apply operator to each value in first operand
        ArrayList<Double> outputs = new ArrayList<>();
        for (Double value : operand1) {
            outputs.add(token.getUnaryOperation().getAction().applyAsDouble(value));
        }

        // Push outputs to stack
        values.push(outputs);
    }

    /**
     * Evaluates a constant token.
     * @param token         The current token being evaluated.
     * @param values        The current stack of intermediary values.
     */
    protected void evaluateConstantToken(ConstantToken token, Stack<List<Double>> values) {
        // Push immediately to output
        values.push(Arrays.asList(token.getValue()));
    }

    /**
     * Gets the map of variable names to values.
     * @return              The map of variable names to values.
     */
    public Map<String, Integer> getVariables() {
        return variables;
    }
}
