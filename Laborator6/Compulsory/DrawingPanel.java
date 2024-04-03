/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private int gridSizeHorizontal; //dimensiunea orizontala a grilei
    private int gridSizeVertical; //dimensiunea verticala a grilei
    //private int[][] stones; //matrice pentru a stoca pietrele plasate pe tabla

    public DrawingPanel() {
        //inițializam dimensiunea grilei la 1 pentru a evita impartirea la zero
        setGridSize(1, 1);
    }

    //metoda pentru setarea dimensiunii grilei
    public void setGridSize(int sizeHorizontal, int sizeVertical) {
        this.gridSizeHorizontal = sizeHorizontal;
        this.gridSizeVertical = sizeVertical;
        //alte actiuni pentru a actualiza desenul in functie de noua dimensiune a grilei
        repaint(); //reafiseaza componenta pentru a reflecta schimbarile
    }

    //metoda pentru a desena grila si pietrele
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //verificam daca dimensiunea grilei este mai mare decat zero pentru a evita impartirea la zero
        if (gridSizeHorizontal > 0 && gridSizeVertical > 0) {
            //desenarea grilei
            int cellWidth = getWidth() / gridSizeHorizontal; //calculam dimensiunea unei celule pe orizontala
            int cellHeight = getHeight() / gridSizeVertical; //calculam dimensiunea unei celule pe verticala
            g.setColor(Color.BLACK);
            //desenam liniile orizontale
            for (int i = 0; i <= gridSizeVertical; i++) {
                g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
            }
            // Desenăm liniile verticale
            for (int i = 0; i <= gridSizeHorizontal; i++) {
                g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            }

           /*//desenarea pietrelor
            int stoneSize = Math.min(cellWidth, cellHeight) / 2; //dimensiunea pietrelor va fi jumatate din dimensiunea celei mai mici celule
            g.setColor(Color.RED); //putem folosi culori diferite pentru pietrele plasate de jucatori diferiti
            for (int i = 0; i < gridSizeHorizontal; i++) {
                for (int j = 0; j < gridSizeVertical; j++) {
                    if (stones[i][j] != 0) { //verificam daca exista o piatra plasata la aceasta pozitie
                        //calculam coordonatele coltului stanga-sus al pietrei
                        int x = i * cellWidth + (cellWidth - stoneSize) / 2;
                        int y = j * cellHeight + (cellHeight - stoneSize) / 2;
                        //desenam pietrele ca cercuri pline
                        g.fillOval(x, y, stoneSize, stoneSize);
                    }
                }
            }*/
        }
    }

    /*//metoda pentru a plasa o piatra la o anumita pozitie
    public void placeStone(int x, int y, int player) {
        //marcam pozitia specificata in matricea de pietre cu numarul jucatorului
        stones[x][y] = player;
        repaint(); //reafiseaza componenta pentru a reflecta schimbarile
    }*/
}
