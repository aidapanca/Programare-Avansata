/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();

    public Game(int n) {
        this.bag = new Bag(n);
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName, this));
    }

    public void start() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public Bag getBag() {
        return bag;
    }
}
