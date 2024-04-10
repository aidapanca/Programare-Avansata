/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import com.github.javafaker.Faker;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private int rows, cols;
    private int canvasWidth = 400, canvasHeight = 400;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private int stoneSize = 20;

    private Game game;

    private int[][] matrixPoints;

    private Point[][] tableMatrix;

    private Player currentPlayer;

    private int previousRow = -1;

    private int previousCol = -1;

    private boolean valid;

    public Game getGame() {
        return game;
    }

    public int[][] getMatrixPoints() {
        return matrixPoints;
    }

    private List<Pair<Integer, Integer>> sticks = new ArrayList<Pair<Integer, Integer>>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols()); //The number of lines and columns from the Configuration Panel
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                //takes coordinates
                int x = e.getX();
                int y = e.getY();
                System.out.println("Mouse pressed on : " + x + "," + y);

                Point clickedPoint = getClickedPoint(x, y);
                boolean found = false;

                for(int i = 0; i < rows;i++){
                    for(int j = 0; j < cols;j++){
                        if(matrixPoints[i][j]==2 || matrixPoints[i][j]==3){
                            found = true;
                        }

                        if(found) {break;}
                    }

                    if(found){break;}
                }
                if(clickedPoint != null && !found){
                    valid = validateStart(clickedPoint.getRow(), clickedPoint.getCol());
                    previousRow = clickedPoint.getRow();
                    previousCol = clickedPoint.getCol();
                }
                else if(clickedPoint != null){
                    valid = validateNextMove(clickedPoint.getRow(), clickedPoint.getCol());
                }

                Player activePlayer;
                if (clickedPoint  != null && valid == true) { //Se valideaza

                    activePlayer = game.getPlayer(); //Am selectat player-ul

                    //desenam pitericelele pentrubplayeri
                    drawPlayer(clickedPoint, activePlayer, (Graphics2D) getGraphics());

                    if(game.isTurn()){
                        matrixPoints[clickedPoint.getRow()][clickedPoint.getCol()] = 3;
                    }
                    else {
                        matrixPoints[clickedPoint.getRow()][clickedPoint.getCol()] = 2;
                    }

                    previousRow = clickedPoint.getRow();
                    previousCol = clickedPoint.getCol();

                    //afisez matricea
                    for(int i=0;i < rows; i++){
                        for(int j=0;j < cols;j++){
                            System.out.print(matrixPoints[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println();
                    }

                    //daca e ok
                    boolean ok = validateFinal(previousRow, previousCol);

                    if(!ok){
                        JOptionPane.showMessageDialog(frame, "Game won by player " + activePlayer.getName(), "Game finished!", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    game.nextTurn(); //trec la urmatorul player
                }
            }
        });
    }

    private void drawPlayer(Point clickedPoint, Player player, Graphics2D g){
        int coordX = padX + clickedPoint.getCol() * cellWidth;
        int coordY = padY + clickedPoint.getRow() * cellHeight;
        g.setColor(player.getColor());
        g.drawOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
        g.fillOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
    }

    private Point getClickedPoint(int mouseX, int mouseY) {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                int centerX = x;
                int centerY = y;
                if (Math.pow(mouseX - centerX, 2) + Math.pow(mouseY - centerY, 2) <= Math.pow((double) stoneSize / 2, 2)) {
                    return tableMatrix[row][col];
                }
            }
        }
        return null;
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        this.game = new Game(rows,cols);
        this.matrixPoints = game.getMatrixLevel(); //aici am matricea
        displayMatrix();
        this.tableMatrix = game.getMatrixPoints();
        setPreferredSize(new Dimension(canvasWidth, canvasHeight)); //dimensiunile obiectului

    }

  //validarea primului click
    public boolean validateStart(int row, int col){
        return matrixPoints[row][col] == 1;
    }


    public boolean validateNextMove(int row, int col){
        if(matrixPoints[row][col] == 1){
            if(matrixPoints[previousRow][previousCol] == 2 || matrixPoints[previousRow][previousCol] == 3){
                if(row == previousRow + 1 && col == previousCol){
                    return true;
                }
                else if(row == previousRow - 1 && col == previousCol){
                    return true;
                }
                else if(row == previousRow && col == previousCol + 1){
                    return true;
                }
                else return row == previousRow && col == previousCol - 1;
            }

            return false;
        }

        return false;
    }

    public boolean validateFinal(int row, int col){
        if(matrixPoints[row][col] == 2 || matrixPoints[row][col] == 3){
            if(row == 0 && col == 0){
                return matrixPoints[row + 1][col] == 1 || matrixPoints[row][col + 1] == 1;
            }
            else if(row == 0 && col == cols - 1){
                return matrixPoints[row + 1][col] == 1 || matrixPoints[row][col - 1] == 1;
            }
            else if(row == rows - 1 && col == 0){
                return matrixPoints[row - 1][col] == 1 || matrixPoints[row][col + 1] == 1;
            }
            else if(row == rows - 1 && col == cols - 1){
                return matrixPoints[row - 1][col] == 1 || matrixPoints[row][col - 1] == 1;
            }
            else if(row == 0){
                return matrixPoints[row + 1][col] == 1 || matrixPoints[row][col + 1] == 1 || matrixPoints[row][col - 1] == 1;
            }
            else if(row == rows - 1){
                return matrixPoints[row - 1][col] == 1 || matrixPoints[row][col + 1] == 1 || matrixPoints[row][col - 1] == 1;
            }
            else if(col == 0){
                return matrixPoints[row - 1][col] == 1 || matrixPoints[row + 1][col] == 1 || matrixPoints[row][col + 1] == 1;
            }
            else if(col == cols - 1){
                return matrixPoints[row - 1][col] == 1 || matrixPoints[row + 1][col] == 1 || matrixPoints[row][col - 1] == 1;
            }
            else return matrixPoints[row - 1][col] == 1 || matrixPoints[row + 1][col] == 1 || matrixPoints[row][col - 1] == 1 || matrixPoints[row][col + 1] == 1;
        }

        return false;
    }

    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight); //This draws the rectangles
        paintGrid(g);
        drawLevel(g);
        takeStones(g);
        Graphics2D g2d = (Graphics2D) graphics;
    }

    protected void takeStones(Graphics2D g){ //vad daca e punct in matrice de int
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrixPoints[i][j] == 2 || matrixPoints[i][j] == 3){
                    Point tempPoint = tableMatrix[i][j];
                    int coordX = padX + tempPoint.getCol() * cellWidth;
                    int coordY = padY + tempPoint.getRow() * cellHeight;
                    if(matrixPoints[i][j] == 2){
                        g.setColor(game.getPlayer1().getColor());
                    }
                    else{
                        g.setColor(game.getPlayer2().getColor());
                    }
                    g.drawOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
                    g.fillOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
                }
            }
        }
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    //linii tabel
    private void drawLevel(Graphics2D g){
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        for(int i = 0;i < rows - 1;i++){
            for(int j = 0;j < cols; j++){
                //redeseneaza per total
                if((matrixPoints[i][j] == 1 && matrixPoints[i + 1][j] == 1) || (matrixPoints[i][j] == 1 && matrixPoints[i + 1][j] == 2) ||
                        (matrixPoints[i][j] == 1 && matrixPoints[i + 1][j] == 3) || (matrixPoints[i][j] == 2 && matrixPoints[i + 1][j] == 1) ||
                        (matrixPoints[i][j] == 2 && matrixPoints[i + 1][j] == 2) || (matrixPoints[i][j] == 2 && matrixPoints[i + 1][j] == 3) ||
                        (matrixPoints[i][j] == 3 && matrixPoints[i + 1][j] == 1) || (matrixPoints[i][j] == 3 && matrixPoints[i + 1][j] == 2) ||
                        (matrixPoints[i][j] == 3 && matrixPoints[i + 1][j] == 3)){
                    int x1 = padX + j * cellWidth;
                    int y1 = padY + i * cellHeight;

                    int x2 = padX + j * cellWidth;
                    int y2 = padY + (i + 1) * cellHeight;

                    g.drawLine(x1,y1,x2,y2);
                }
            }
        }

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols - 1; j++){

                if((matrixPoints[i][j] == 1 && matrixPoints[i][j + 1] == 1) || (matrixPoints[i][j] == 1 && matrixPoints[i][j + 1] == 2) ||
                        (matrixPoints[i][j] == 1 && matrixPoints[i][j + 1] == 3) || (matrixPoints[i][j] == 2 && matrixPoints[i][j + 1] == 1) ||
                        (matrixPoints[i][j] == 2 && matrixPoints[i][j + 1] == 2) || (matrixPoints[i][j] == 2 && matrixPoints[i][j + 1] == 3) ||
                        (matrixPoints[i][j] == 3 && matrixPoints[i][j + 1] == 1) || (matrixPoints[i][j] == 3 && matrixPoints[i][j + 1] == 2) ||
                        (matrixPoints[i][j] == 3 && matrixPoints[i][j + 1] == 3)){
                    int x1 = padX + j * cellWidth;
                    int y1 = padY + i * cellHeight;

                    int x2 = padX + (j + 1) * cellWidth;
                    int y2 = padY + i * cellHeight;

                    g.drawLine(x1,y1,x2,y2);
                }
            }
        }
    }

    private void displayMatrix(){
        for(int i = 0;i < rows;i++){
            for(int j = 0; j < cols;j++){
                System.out.print(matrixPoints[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void setMatrixPoints(int[][] matrixPoints) {
        this.matrixPoints = matrixPoints;
    }

    public int getPreviousRow() {
        return previousRow;
    }

    public int getPreviousCol() {
        return previousCol;
    }

    public void setPreviousRow(int previousRow) {
        this.previousRow = previousRow;
    }

    public void setPreviousCol(int previousCol) {
        this.previousCol = previousCol;
    }
}

