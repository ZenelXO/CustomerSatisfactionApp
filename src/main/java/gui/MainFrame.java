package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JLabel bottomLabel = new JLabel("HOLA");

    public MainFrame() throws IOException {
        this.setTitle("Encuesta de Satisfaccion");
        this.setIconImage(loadIconImage());
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Main Container
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(Color.GRAY);
            //Top Panel
            mainContainer.add(new TopPanel().load(), BorderLayout.NORTH);
            //Mid Panel
            mainContainer.add(new MidPanel(bottomLabel).load(), BorderLayout.CENTER);
            //Bottom Panel
            mainContainer.add(new BottomPanel(bottomLabel).load(), BorderLayout.SOUTH);
    }

    private Image loadIconImage() {
        return new ImageIcon("src/main/java/assets/iconImage.png").getImage();
    }
}