/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    DrawingPanel drawingPanel;
    ControlPanel controlPanel;

    public MainFrame() {
        super("My game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        configPanel = new ConfigPanel();
        add(configPanel, BorderLayout.NORTH);

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        controlPanel = new ControlPanel();
        add(controlPanel, BorderLayout.SOUTH);

        //adauga un ascultator pentru butonul "New Game"
        configPanel.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gridSizeHorizontal = configPanel.getGridSizeHorizontal(); //obtine dimensiunea orizontala a grilei din ConfigPanel
                int gridSizeVertical = configPanel.getGridSizeVertical(); //obtine dimensiunea verticala a grilei din ConfigPanel
                drawingPanel.setGridSize(gridSizeHorizontal, gridSizeVertical); //seteaza dimensiunea grilei in DrawingPanel
                drawingPanel.repaint(); //redeseneaza DrawingPanel pentru a reflecta noile dimensiuni ale grilei
            }
        });

        pack();
        setLocationRelativeTo(null);
    }


}
