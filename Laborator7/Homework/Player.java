package Homework;

import java.util.*;

public class Player implements Runnable {
    private Game game;

    private String name;
    private Bag bag;
    private final Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
    private int longestSequence = 0;
    private final Object turnLock;
    private static int currentPlayerIndex = 0;
    private final int playerIndex;

    public Player(String name, Bag bag, Object turnLock, int playerIndex) {
        this.name = name;
        this.bag = bag;
        this.turnLock = turnLock;
        this.playerIndex = playerIndex;
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) { //It sets the game the player is attributed
        this.game = game;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (game.getTurnLock()) {
                while (currentPlayerIndex != playerIndex) {
                    try {
                        turnLock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(name + " was interrupted but still exists.");
                        return;
                    }
                }
                if (Thread.interrupted()) {
                    System.out.println(name + " was interrupted while active but still exists.");
                    return;
                }

                Token token = bag.extractToken();
                //daca jetoanele s au terminat sau jucatorul a atins lungimea maxima a secventei, se termina executia
                if (token == null || longestSequence == game.getN()) {
                    notifyNext();
                    break;
                }

                System.out.println(name + " extracted: " + token);
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    System.out.println(name + " was interrupted during sleepy time but still exists.");
                    return;
                }
                processToken(token);

                notifyNext();
            }
        }
    }

    private void notifyNext() {
        synchronized (turnLock) {
            currentPlayerIndex = (currentPlayerIndex + 1) % game.getPlayerCount();
            turnLock.notifyAll();
        }
    }

    //o lista de adiacenta pt a cauta cicluri
    private void processToken(Token token) {
        int first = token.getFirst();
        int second = token.getSecond();
        adjacencyList.putIfAbsent(first, new HashSet<>());
        adjacencyList.get(first).add(second);
        findCycles(first, second);
    }

    //determinare a noilor cicluri
    private void findCycles(int start, int newlyConnected) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> path = new Stack<>();
        path.push(start);
        dfs(start, start, visited, path);
    }

    //dfs recursive method
    private void dfs(int current, int start, Set<Integer> visited, Stack<Integer> path) {
        if (!adjacencyList.containsKey(current)) return;
        for (int neighbor : adjacencyList.get(current)) {
            if (neighbor == start && path.size() > 1) {
                if (path.size() > longestSequence) {
                    longestSequence = path.size();
                    System.out.println(name + " found a new longest sequence of length " + longestSequence);
                }
                continue;
            }
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                path.push(neighbor);
                dfs(neighbor, start, visited, path);
                path.pop();
                visited.remove(neighbor);
            }
        }
    }

    public int getLongestSequence()  {
        return longestSequence;
    }
}
