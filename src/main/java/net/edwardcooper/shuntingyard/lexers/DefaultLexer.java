package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Arrays;

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

    @Override
    public Token readToken(String input, int start) throws TokenNotRecognisedException {
        throw new TokenNotRecognisedException(input, start);
    }

    @Override
    public Type[] getSupportedOutputTokenTypes() {
        return new Type[] {};
    }
}
