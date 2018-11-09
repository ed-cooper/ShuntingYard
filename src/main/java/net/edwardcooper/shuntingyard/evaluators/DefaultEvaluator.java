package net.edwardcooper.shuntingyard.evaluators;

import net.edwardcooper.shuntingyard.model.Token;

import java.util.List;

/**
 * The default evaluator for evaluating maths expressions.
 *
 * The supported input token types of this class are: <code>OperatorToken</code>, <code>ConstantToken</code>,
 * <code>VariableToken</code>.
 */
public class DefaultEvaluator extends EvaluatorBase {
    @Override
    public List<Double> evaluate(List<Token> equation) {
        return null;
    }
}
