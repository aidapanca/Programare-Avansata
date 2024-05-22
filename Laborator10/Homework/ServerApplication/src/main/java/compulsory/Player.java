/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;

public class Player {
    private final String name;
    private long timeRemaining;
    private Board board;

    public Player(String name, long timeLimit) {
        this.name = name;
        this.timeRemaining = timeLimit;
    }

    public String getName() {
        return name;
    }

    public long getTimeRemaining() {
        return timeRemaining;
    }

    public void updateTime(long timeSpent) {
        this.timeRemaining -= timeSpent;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
