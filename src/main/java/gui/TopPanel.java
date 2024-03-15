package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends Component {
    public TopPanel(){

    }

    public Component load(){
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
            //Componentes
            top.add(loadInfo());

        return top;
    }

    private Component loadInfo() {
        JLabel infoLabel = new JLabel();
        infoLabel.setPreferredSize(new Dimension(500, 150));
        infoLabel.setText("Encuesta de Satisfacción");
        infoLabel.setFont(new Font(Font.SANS_SERIF, 3, 40));
        return infoLabel;
    }
}