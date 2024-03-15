package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImage {
    private String state;
    private BufferedImage stateImage;

    public LoadImage() {

    }

    public Icon loadRed(String red) throws IOException {
        return new ImageIcon(stateImage = ImageIO.read(new File("src/main/java/assets/rojo.png")));
    }

    public Icon loadYellow(String yellow) throws IOException {
        return new ImageIcon(stateImage = ImageIO.read(new File("src/main/java/assets/amarillo.png")));
    }

    public Icon loadGreen(String green) throws IOException {
        return new ImageIcon(stateImage = ImageIO.read(new File("src/main/java/assets/verde.png")));
    }
}
