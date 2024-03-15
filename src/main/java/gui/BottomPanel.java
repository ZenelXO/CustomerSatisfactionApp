package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BottomPanel extends JPanel {
    private JLabel bottomLabel;

    public BottomPanel(JLabel bottomLabel){
        this.bottomLabel = bottomLabel;
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public Component load(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(new LineBorder(Color.black, 1));
            //Componentes
            this.add(loadText());

        return this;
    }

    private Component loadText() {
        bottomLabel.setText("Farmacia Fr.Ramos del Copon");
        bottomLabel.setPreferredSize(new Dimension(500, 70));
        bottomLabel.setFont(new Font(Font.SANS_SERIF, 3, 20));

        return bottomLabel;
    }
}