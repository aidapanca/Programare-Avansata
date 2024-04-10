/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(4); // Exemplu cu n = 4
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.addPlayer("Player 3");

        game.start();
    }
}
