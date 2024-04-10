/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;
import javax.swing.JFrame;

import java.awt.*;


public class MainFrame extends JFrame{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); //inchidem fereastra prin click

        //componentele
        controlPanel=new ControlPanel(this);
        configPanel=new ConfigPanel(this);
        canvas = new DrawingPanel(this);

        //componenta si locul (sus mijloc jos)
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        //redimensiune
        pack();

        //sa fie imag vizibila pe ecran
        setVisible(true);

    }

}
