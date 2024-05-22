/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;

public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public boolean placeShip(int x, int y, int length, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < length; i++) {
                if (x + i >= 10 || grid[x + i][y] != '-') return false;
            }
            for (int i = 0; i < length; i++) {
                grid[x + i][y] = 'S';
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (y + i >= 10 || grid[x][y + i] != '-') return false;
            }
            for (int i = 0; i < length; i++) {
                grid[x][y + i] = 'S';
            }
        }
        return true;
    }

    public boolean applyMove(Move move) {
        int x = move.getX();
        int y = move.getY();

        if (grid[x][y] == '-') {
            grid[x][y] = 'O'; // Miss
            return false;
        } else if (grid[x][y] == 'S') {
            grid[x][y] = 'X'; // Hit
            return true;
        } else {
            return false; // Already targeted
        }
    }

    public boolean hasLost() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }

}
