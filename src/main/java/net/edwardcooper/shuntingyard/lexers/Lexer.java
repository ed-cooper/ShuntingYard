package net.edwardcooper.shuntingyard.lexers;

import net.edwardcooper.shuntingyard.model.Token;

public abstract class Lexer {
    public abstract Token[] ReadTokens(String input);

    public abstract Token ReadToken(String input, int start);
}
