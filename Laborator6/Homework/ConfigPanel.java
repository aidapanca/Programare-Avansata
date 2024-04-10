/**
 @author Pâncă Aida-Gabriela, A5
 **/
package Homework;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel label;
    private JSpinner spinnerRows;
    private JSpinner spinnerColumns;

    private JButton buttonCreated;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerColumns = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        buttonCreated = new JButton("Create");

        add(label);
        add(spinnerRows);
        add(spinnerColumns);
        add(buttonCreated);

        buttonCreated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gridRows = (int) spinnerRows.getValue();
                int gridColumns = (int) spinnerColumns.getValue();
                frame.canvas.init(gridRows, gridColumns);
                frame.canvas.repaint();
            }
        });
    }

    public int getRows() {
        return (int) spinnerRows.getValue();
    }

    public int getCols() {

        return (int) spinnerColumns.getValue();
    }
}
