package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.Token;
import net.edwardcooper.shuntingyard.model.TokenNotRecognisedException;

import java.util.ArrayList;
import java.util.List;

public abstract class LexerBase implements Lexer {

    @Override
    public List<Token> ReadTokens(String input) {
        int position = 0;
        ArrayList<Token> tokens = new ArrayList<>();

        while (position < input.length()) {
            Token token = ReadToken(input, position);
            tokens.add(token);
            position += token.getLiteral().length();
        }

        return tokens;
    }

}
