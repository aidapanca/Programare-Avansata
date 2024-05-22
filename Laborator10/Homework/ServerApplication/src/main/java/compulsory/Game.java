/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private final String gameId;
    private final Map<String, Player> players;
    private final Board board1;
    private final Board board2;
    private long timeLimit;

    public Game(String gameId, long timeLimit) {
        this.gameId = gameId;
        this.players = new HashMap<>();
        this.board1 = new Board();
        this.board2 = new Board();
        this.timeLimit = timeLimit;
    }

    public String getGameId() {
        return gameId;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void addPlayer(Player player) {
        if (players.size() < 2) {
            players.put(player.getName(), player);
            if (players.size() == 1) {
                player.setBoard(board1);
            } else {
                player.setBoard(board2);
            }
        } else {
            throw new IllegalStateException("Game is already full");
        }
    }

    public String makeMove(String playerName, Move move) {
        if (players.size() < 2) {
            throw new IllegalStateException("Not enough players to start the game");
        }

        Board opponentBoard = players.values().stream()
                .filter(p -> !p.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Opponent not found"))
                .getBoard();

        boolean isHit = opponentBoard.applyMove(move);
        return isHit ? "Hit!" : "Miss!";
    }

    public boolean isGameOver() {
        return board1.hasLost() || board2.hasLost();
    }

    public void updateTime(String playerName, long timeSpent) {
        Player player = players.get(playerName);
        if (player != null) {
            player.updateTime(timeSpent);
            if (player.getTimeRemaining() <= 0) {
                System.out.println("Player " + playerName + " has run out of time and loses!");
            }
        }
    }

    public void placeShips(String playerName, int x, int y, int length, boolean horizontal) {
        Player player = players.get(playerName);
        if (player != null) {
            boolean success = player.getBoard().placeShip(x, y, length, horizontal);
            if (!success) {
                throw new IllegalStateException("Unable to place ship at the specified location");
            }
        } else {
            throw new IllegalStateException("Player not found");
        }
    }
}
