package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.TokenNotRecognisedException;

import java.util.ArrayList;
import java.util.List;

public abstract class LexerBase implements Lexer {
    @Override
    public List<Token> readTokens(String input) throws TokenNotRecognisedException {
        String preprocessed = preprocess(input);

        int position = 0;
        ArrayList<Token> tokens = new ArrayList<>();

        while (position < preprocessed.length()) {
            Token token = readToken(preprocessed, position);
            tokens.add(token);
            position += token.getLiteral().length();
        }

        return tokens;
    }

    /**
     * Pre-processes an input so that tokens can be sequentially read without further processing.
     * @param input                         The input to pre-process.
     * @return                              A string in the correct form for tokens to be sequentially read from.
     */
    public String preprocess(String input) {
        return input;
    }

    /**
     * Reads a single token at the specified location within an input string.
     * @param input                         The input string to find a token within.
     * @param start                         The position of the first character of the token.
     * @return                              The token at the specified location within the input string.
     * @throws TokenNotRecognisedException  Thrown when a token could not be recognised.
     */
    public abstract Token readToken(String input, int start) throws TokenNotRecognisedException;
}
