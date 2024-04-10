/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private final List<Token> tokens = Collections.synchronizedList(new ArrayList<>());

    public Bag(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tokens.add(new Token(i, j));
            }
        }
        Collections.shuffle(tokens);
    }

    public synchronized Token extractToken() {
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens.remove(0);
    }
}
