/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

public class Player implements Runnable {
    private final String name;
    private final Game game;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            Token extractedToken = game.getBag().extractToken();
            if (extractedToken == null) {
                break;
            }
            System.out.println(name + " extracted " + extractedToken);
            //aici o sa adaug ulterior logica pentru verificarea secvențelor
        }
    }
}

