/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    private JButton loadBtn = new JButton("Load");
    private JButton exitBtn = new JButton("Exit");
    private JButton saveBtn = new JButton("Save");

    private JButton exportBtn = new JButton("Export");

    private GameSave saveData;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager
        setLayout(new GridLayout(1, 4));

        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        add(exportBtn);

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);
        exportBtn.addActionListener(this::exportToPNG);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose(); //Closes the main panel
    }

    private void saveGame(ActionEvent e) {
        File fileSaved = new File("gameSavedData.txt");

        //this.saveData = new GameSave(this.frame.canvas.getMatrixPoints());
        this.saveData = new GameSave(this.frame.canvas.getMatrixPoints(), this.frame.canvas.getPreviousRow(), this.frame.canvas.getPreviousCol()); //Containes the data to be saved
        this.saveData.serialize("gameSavedData.txt"); //It serializes and saves the data
    }

    private void loadGame(ActionEvent e) {
        this.saveData = new GameSave(this.frame.canvas.getMatrixPoints(), this.frame.canvas.getPreviousRow(), this.frame.canvas.getPreviousCol());
        this.saveData = this.saveData.deserialize("gameSavedData.txt"); //it deserializes and reads data
        int[][] matrix = this.saveData.getSaveMatrix();
        int coordX = this.saveData.getLastX();
        int coordY = this.saveData.getLastY();

        this.frame.canvas.init(matrix.length,matrix[0].length);
        this.frame.canvas.setMatrixPoints(matrix);
        this.frame.canvas.setPreviousRow(coordX);
        this.frame.canvas.setPreviousCol(coordY);
        this.frame.repaint();
    }

    private void exportToPNG(ActionEvent e) {
        try {
            BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics(); //it creates the canva for the image and it allows drawing the image
            frame.paint(g2d); //It is used to draw the new image
            File outputFile = new File("gameBoard.png");
            ImageIO.write(image, "png", outputFile);
            JOptionPane.showMessageDialog(null, "Image exported successfully to gameBoard.png", "Export Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error exporting image", "Export Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
