/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    JLabel labelHorizontal;
    JLabel labelVertical;
    JTextField gridSizeInputHorizontal;
    JTextField gridSizeInputVertical;
    JButton newGameButton;

    public ConfigPanel() {
        labelHorizontal = new JLabel("Grid size (horizontal):");
        labelVertical = new JLabel("Grid size (vertical):");
        gridSizeInputHorizontal = new JTextField(5);
        gridSizeInputVertical = new JTextField(5);
        newGameButton = new JButton("New Game");

        setLayout(new FlowLayout());
        add(labelHorizontal);
        add(gridSizeInputHorizontal);
        add(labelVertical);
        add(gridSizeInputVertical);
        add(newGameButton);
    }

    public int getGridSizeHorizontal() {
        return Integer.parseInt(gridSizeInputHorizontal.getText());
    }

    public int getGridSizeVertical() {
        return Integer.parseInt(gridSizeInputVertical.getText());
    }
}

