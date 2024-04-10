/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import java.awt.*;

public class Game {
    private RandomLevel randomGenerator;

    private Point[][] matrixPoints;

    private int rows;

    private int cols;

    private int[][] matrixLevel;

    private Player player1;

    private Player player2;

    private boolean turn;

    public Game(int rows, int cols){
        this.rows = rows;
        this.cols = cols;

        matrixPoints = new Point[rows][cols];

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                matrixPoints[i][j] = new Point(i,j,Color.BLACK);
            }
        }

        randomGenerator = new RandomLevel(rows,cols);

        matrixLevel = randomGenerator.getMatrixPoints();

        player1 = new Player(Color.BLUE, "Player1");
        player2 = new Player(Color.RED, "Player2");

        this.turn = false;
    }

    public void nextTurn(){
        if(turn) {turn = false;}
        else {turn = true;}
    }


    public Player getPlayer(){
        if(turn){
            return player2;
        }

        return player1;
    }

    public int[][] getMatrixLevel() {
        return matrixLevel;
    }

    public Point[][] getMatrixPoints(){
        return matrixPoints;
    }

    public boolean isTurn() {
        return turn;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
