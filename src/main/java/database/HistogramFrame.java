package database;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HistogramFrame extends JFrame {
    public HistogramFrame() throws HeadlessException, IOException {
        this.setTitle("Histogram Viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            //Componentes
            this.add(new Histogram().createHistogram());
    }
}