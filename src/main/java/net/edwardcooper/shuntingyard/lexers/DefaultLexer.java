package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.*;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.lir.aarch64.AArch64ArithmeticOp;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * The default lexer for tokenising maths expressions.
 */
public class DefaultLexer extends LexerBase {
    private List<Operator> operators = Arrays.asList(
        new BinaryOperator("+", 2, true,  (x, y) -> x + y),
        new BinaryOperator("-", 2, true,  (x, y) -> x - y),
        new BinaryOperator("*", 3, true,  (x, y) -> x * y),
        new BinaryOperator("×", 3, true,  (x, y) -> x * y),
        new BinaryOperator("/", 3, true,  (x, y) -> x / y),
        new BinaryOperator("÷", 3, true,  (x, y) -> x / y),
        new BinaryOperator("^", 4, false, (x, y) -> Math.pow(x, y)),
        new UnaryOperator("−",      (x) -> -x),
        new UnaryOperator("sqrt",   (x) -> Math.sqrt(x)),
        new UnaryOperator("√",      (x) -> Math.sqrt(x)),
        new UnaryOperator("sinh",   (x) -> Math.sinh(x)),
        new UnaryOperator("cosh",   (x) -> Math.cosh(x)),
        new UnaryOperator("tanh",   (x) -> Math.tanh(x)),
        new UnaryOperator("sin",    (x) -> Math.sin(x)),
        new UnaryOperator("cos",    (x) -> Math.cos(x)),
        new UnaryOperator("tan",    (x) -> Math.tan(x)),
        new UnaryOperator("asinh",  (x) -> Math.log(x + Math.sqrt(x * x + 1))),
        new UnaryOperator("acosh",  (x) -> Math.log(x + Math.sqrt(x * x - 1))),
        new UnaryOperator("atanh",  (x) -> Math.log((1 + x) / (1 - x)) / 2),
        new UnaryOperator("asin",   (x) -> Math.asin(x)),
        new UnaryOperator("arcsin", (x) -> Math.asin(x)),
        new UnaryOperator("acos",   (x) -> Math.acos(x)),
        new UnaryOperator("arccos", (x) -> Math.acos(x)),
        new UnaryOperator("atan",   (x) -> Math.atan(x)),
        new UnaryOperator("arctan", (x) -> Math.atan(x)),
        new UnaryOperator("log_10", (x) -> Math.log10(x)),
        new UnaryOperator("log_2",  (x) -> Math.log(x) / Math.log(2)),
        new UnaryOperator("ln",     (x) -> Math.log(x)),
        new MultiOutputUnaryOperator("±", (x) -> Arrays.asList(x, -x)),
        new MultiOutputUnaryOperator("∓", (x) -> Arrays.asList(-x, x))
    );
    private List<String> variables = Arrays.asList();
    private Pattern findNegate = Pattern.compile("(?<!(\\d|\\)|e|π|pi))-");

    @Override
    public String preprocess(String input) {
        // Pre-processing steps:
        // 1: Remove all whitespace
        // 2: Replace all unary negation operators with "−" characters to avoid conflict with the "-" binary operator
        return findNegate.matcher(input.replace(" ", "")).replaceAll("−");
    }

    @Override
    public Token readToken(String input, int start) throws TokenNotRecognisedException {
        // Detect operators
        for (Operator operator: operators) {
            if (input.startsWith(operator.getSymbol(), start)) {
                if (operator instanceof BinaryOperator) {
                    return new BinaryOperatorToken(operator.getSymbol(), (BinaryOperator)operator);
                } else if (operator instanceof UnaryOperator) {
                    return new UnaryOperatorToken(operator.getSymbol(), (UnaryOperator)operator);
                } else if (operator instanceof MultiOutputUnaryOperator) {
                    return new MultiOutputUnaryOperatorToken(operator.getSymbol(), (MultiOutputUnaryOperator)operator);
                }
            }
        }
        // No match found
        throw new TokenNotRecognisedException(input, start);
    }

    @Override
    public Type[] getSupportedOutputTokenTypes() {
        return new Type[] {
                BinaryOperatorToken.class,
                UnaryOperatorToken.class,
                MultiOutputUnaryOperatorToken.class,
                ConstantToken.class,
                VariableToken.class,
                BracketToken.class
        };
    }

    /**
     * Gets the list of operators supported by this lexer.
     * @return              The list of operators supported by this lexer.
     */
    public List<Operator> getOperators() {
        return operators;
    }

    /**
     * Gets the list of variable names to search for.
     * @return              The list of variable names to search for.
     */
    public List<String> getVariables() {
        return variables;
    }
}
