package gui;

import com.sun.tools.javac.Main;
import database.MainDataBase;
import src.LoadImage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MidPanel extends JPanel {
    private Image backgroundImage;
    private JButton redButton = new JButton();
    private JButton yellowButton = new JButton();
    private JButton greenButton = new JButton();
    private JLabel bottomLabel;
    private MainDataBase database = new MainDataBase();
    private int votacionesNegativas;
    private int votacionesMedias;
    private int votacionesPositivas;

    public MidPanel(JLabel bottomLabel) throws IOException {
        this.bottomLabel = bottomLabel;
        backgroundImage = new ImageIcon("src/main/java/assets/iconImage.png").getImage();

        // Cargar los datos actuales de la base de datos al iniciar el panel
        votacionesNegativas = Integer.parseInt(database.loadNegativas());
        votacionesMedias = Integer.parseInt(database.loadMedias());
        votacionesPositivas = Integer.parseInt(database.loadPositivas());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        // g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public Component load() throws IOException {
        this.setLayout(new GridLayout(1,3,0,0));
        this.setBorder(new LineBorder(Color.BLACK, 1));
            // Componentes
            this.add(loadRedButton());
            this.add(loadYellowButton());
            this.add(loadGreenButton());

        return this;
    }

    private Component loadRedButton() throws IOException {
        redButton.setBounds(0, 0, 44, 44);
        redButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        redButton.setIcon(new LoadImage().loadRed("red"));
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomLabel.setText("Gracias por su participación, rojo!");
                votacionesNegativas++;
                try {
                    database.setNegativas(String.valueOf(votacionesNegativas));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Timer timer = new Timer(1000, new ActionListener() {
                    int segundos = 5;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        segundos--;
                        if(segundos == 0){
                            bottomLabel.setText("Farmacia Fr.Ramos del Copon");
                            ((Timer)e.getSource()).stop();
                        }
                    }
                });
                timer.start();
            }
        });

        return redButton;
    }

    private Component loadYellowButton() throws IOException {
        yellowButton.setBounds(375, 15, 44, 44);
        yellowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yellowButton.setIcon(new LoadImage().loadYellow("yellow"));
        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomLabel.setText("Gracias por su participación, amarillo!");
                votacionesMedias++;
                try {
                    database.setMedias(String.valueOf(votacionesMedias));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Timer timer = new Timer(1000, new ActionListener() {
                    int segundos = 5;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        segundos--;
                        if(segundos == 0){
                            bottomLabel.setText("Farmacia Fr.Ramos del Copon");
                            ((Timer)e.getSource()).stop();
                        }
                    }
                });
                timer.start();
            }
        });

        return yellowButton;
    }

    private Component loadGreenButton() throws IOException {
        greenButton.setBounds(1300, 400, 44, 44);
        greenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        greenButton.setIcon(new LoadImage().loadGreen("green"));
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomLabel.setText("Gracias por su participación, verde!");
                votacionesPositivas++;
                try {
                    database.setPositivas(String.valueOf(votacionesPositivas));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Timer timer = new Timer(1000, new ActionListener() {
                    int segundos = 5;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        segundos--;
                        if(segundos == 0){
                            bottomLabel.setText("Farmacia Fr.Ramos del Copon");
                            ((Timer)e.getSource()).stop();
                        }
                    }
                });
                timer.start();
            }
        });

        return greenButton;
    }
}
