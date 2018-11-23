package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.*;

import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The default lexer for tokenising maths expressions.
 *
 * The supported output token types of this class are: <code>OperatorToken</code>, <code>ConstantToken</code>,
 * <code>VariableToken</code>, <code>BracketToken</code>.
 */
public class DefaultLexer extends LexerBase {
    private List<Operator> operators = new ArrayList<>(Arrays.asList(
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
    ));
    private List<BracketToken> brackets = new ArrayList<>(Arrays.asList(
        new BracketToken("(", true),
        new BracketToken(")", false),
        new BracketToken("[", true),
        new BracketToken("]", false),
        new BracketToken("{", true),
        new BracketToken("}", false)
    ));
    private HashMap<String, Double> constants = new HashMap<String, Double>();
    private List<String> variables = new ArrayList<>();
    private Pattern findNegate = Pattern.compile("(?<!(\\d|\\)|e|π|pi))-");
    private Pattern findNumbers = Pattern.compile("^\\d+(\\.\\d+)?");

    /**
     * DefaultLexer class constructor
     */
    public DefaultLexer() {
        // Initialise constants
        constants.put("π", Math.PI);
        constants.put("e", Math.E);
        constants.put("pi", Math.PI);

    }

    @Override
    public String preprocess(String input) {
        // Pre-processing steps:
        // 1: Remove all whitespace
        // 2: Make lowercase
        // 3: Replace all unary negation operators with "−" characters to avoid conflict with the "-" binary operator
        return findNegate.matcher(input.replace(" ", "").toLowerCase()).replaceAll("−");
    }

    @Override
    public Token readToken(String input, int start) throws TokenNotRecognisedException {
        // Detect operators
        for (Operator operator: operators) {
            if (input.startsWith(operator.getSymbol(), start)) {
                return operator.getToken();
            }
        }
        // Detect variables
        for (String variable : variables) {
            if (input.startsWith(variable, start)) {
                return new VariableToken(variable);
            }
        }
        // Detect constants
        for (String constant : constants.keySet()) {
            if (input.startsWith(constant, start)) {
                return new ConstantToken(constant, constants.get(constant));
            }
        }
        // Detect brackets
        for (BracketToken bracket : brackets) {
            if (input.startsWith(bracket.getLiteral(), start)) {
                return bracket;
            }
        }
        // Detect numbers
        Matcher findNumbersMatcher = findNumbers.matcher(input.substring(start));
        if (findNumbersMatcher.find()) {
            String match = findNumbersMatcher.group();
            return new ConstantToken(match, Double.parseDouble(match));
        }
        // No match found
        throw new TokenNotRecognisedException(input, start);
    }

    /**
     * Gets the list of operators supported by this lexer.
     * @return              The list of operators supported by this lexer.
     */
    public List<Operator> getOperators() {
        return operators;
    }

    /**
     * Gets the list of brackets to search for.
     * @return              The list of brackets to search for.
     */
    public List<BracketToken> getBrackets() {
        return brackets;
    }

    /**
     * Gets the collection of constants to search for.
     * @return              The collection of constants to search for.
     */
    public Map<String, Double> getConstants() {
        return constants;
    }

    /**
     * Gets the list of variable names to search for.
     * @return              The list of variable names to search for.
     */
    public List<String> getVariables() {
        return variables;
    }
}
