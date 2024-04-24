/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Bag {
    //o structura de tip stiva Stack pt a stoca jetoanele (tokens)
    private Stack<Token> tokens = new Stack<>();
    private int n;

    public Bag(int n) {
        this.n = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tokens.push(new Token(i, j));
                }
            }
        }
        Collections.shuffle(tokens);
    }

    //extragem tokenurile si returnam perechea extrasa
    public synchronized Token extractToken() {
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens.pop();
    }

}
