/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    JButton loadButton;
    JButton saveButton;
    JButton exitButton;

    public ControlPanel() {
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");

        setLayout(new FlowLayout());
        add(loadButton);
        add(saveButton);
        add(exitButton);
    }
}
