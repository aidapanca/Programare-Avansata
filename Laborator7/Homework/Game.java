package Homework;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players = new ArrayList<>();

    private final List<Thread> threads = new ArrayList<>();

    private final Object turnLock = new Object();

    private final Bag bag = new Bag(5);

    private int n;

    private int playerCount = 3;

    public Game(int n){
        this.n = n;
    }

    public Bag getBag(){
        return bag;
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
        Thread thread = new Thread(player);
        threads.add(thread);

    }

    public Object getTurnLock() {
        return turnLock;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void play(){
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted.");
            }
        }
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getN() {
        return n;
    }

    public static void main(String[] args) {
        Game game = new Game(5);
        game.addPlayer(new Player("Player 0", game.getBag(), game.getTurnLock(), 0));
        game.addPlayer(new Player("Player 1", game.getBag(), game.getTurnLock(), 1));
        game.addPlayer(new Player("Player 2", game.getBag(), game.getTurnLock(), 2));

        Thread timekeeperThread = new Thread(new Timekeeper(game.getThreads(), 60000));
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();

        game.play();

        List<Player> playerList = game.getPlayers();

        for (Player player : playerList) {
            System.out.println(player.getName() + " longest sequence: " + player.getLongestSequence());
        }

        List <String> winners= new ArrayList<>();

        int maxSequence = -1;

        for(Player player : playerList)
        {
            if(maxSequence < player.getLongestSequence())
            {
                maxSequence = player.getLongestSequence();
                winners.clear();
                winners.add(player.getName());
            }
            else if(player.getLongestSequence() == maxSequence){
                winners.add(player.getName());
            }

        }

        if(winners.size() > 1)
        {
            System.out.println("It's a tie between: ");
            for(String winner : winners)
            {
                System.out.println(winner);
            }
        }
        else if(winners.size() == 1)
        {
            System.out.println("The winner is: " + winners.get(0));
        }
        else
        {
            System.out.println("No winner found");
        }

    }
}
