package net.edwardcooper.shuntingyard.parsers;

import net.edwardcooper.shuntingyard.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The default parser for converting equations into RPN form.
 *
 * The supported input token types of this class are: <code>OperatorToken</code>, <code>ConstantToken</code>,
 * <code>VariableToken</code>, <code>BracketToken</code>.
 *
 * The supported output token types of this class are: <code>OperatorToken</code>, <code>ConstantToken</code>,
 * <code>VariableToken</code>.
 */
public class DefaultParser extends ParserBase {
    @Override
    public List<Token> parse(List<Token> equation) {
        ArrayList<Token> outputRPN = new ArrayList<>(); // Output RPN
        Stack<Token> operatorStack = new Stack<>();     // Used to temporarily hold operators

        // For each token in the equation
        for (Token token: equation) {
            // Switch based on token type
            if (token instanceof ConstantToken || token instanceof VariableToken) { // Constants & Variables
                // Treat both constants and variables as values
                processValue(token, outputRPN, operatorStack);
            } else if (token instanceof BinaryOperatorToken) { // Binary ops
                processBinaryOperator((BinaryOperatorToken)token, outputRPN, operatorStack);
            } else {
                // No match found for token type
                throw new UnsupportedTokenException(equation, token);
            }
        }

        // Return RPN output
        return outputRPN;
    }

    /**
     * Processes a token that contains a value.
     * @param currentToken          The token currently being parsed.
     * @param outputRPN             The RPN output of the parser.
     * @param operatorStack         The current operator stack.
     */
    protected void processValue(Token currentToken, ArrayList<Token> outputRPN, Stack<Token> operatorStack) {
        // Immediately add the token to the output
        outputRPN.add(currentToken);

        // Pop all of the unary operators and multi-output unary operators at the top of the stack and add them to
        // the output
        while (!operatorStack.empty() &&
                (operatorStack.peek() instanceof UnaryOperatorToken ||
                        operatorStack.peek() instanceof MultiOutputUnaryOperatorToken)) {
            outputRPN.add(operatorStack.pop());
        }
    }

    /**
     * Processes a token that is a binary operator.
     * @param currentToken          The token currently being parsed.
     * @param outputRPN             The RPN output of the parser.
     * @param operatorStack         The current operator stack.
     */
    protected void processBinaryOperator(BinaryOperatorToken currentToken, ArrayList<Token> outputRPN,
                                         Stack<Token> operatorStack) {
        while (!operatorStack.empty()) {
            // Get the operator at the top of the stack
            Token operator = operatorStack.peek();

            // As soon as a token that isn't a binary operator is met, stop
            if (!(operator instanceof BinaryOperatorToken)) {
                break;
            }

            // Compare the precedence of the current operator being processed to the precedence of the operator on
            // the stack
            BinaryOperatorToken binaryOperator = (BinaryOperatorToken)operator;
            int diff = currentToken.getBinaryOperation().getPrecedence() -
                    binaryOperator.getBinaryOperation().getPrecedence();

            // If the operator at the top of the stack has greater precedence, or they have equal precedence and the
            // current operator is left associative, pop the operator and add it to the stack
            // Otherwise, break, as we know there won't be any other operators in the stack satisfying the condition
            if (diff < 0 || (diff == 0 && currentToken.getBinaryOperation().getLeftAssociative())) {
                outputRPN.add(operatorStack.pop());
            } else{
                break;
            }
        }

        // Push the current operator onto the stack
        operatorStack.push(currentToken);
    }
}
