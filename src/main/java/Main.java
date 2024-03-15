import database.Histogram;
import database.HistogramFrame;
import database.MainDataBase;
import gui.MainFrame;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //Aplication Interface
        MainFrame layout = new MainFrame();
        layout.setVisible(true);

        //Historam Interface
        //HistogramFrame histogram = new HistogramFrame();
        //histogram.setVisible(true);

        //Leer Base de Datos
        MainDataBase database = new MainDataBase();
        System.out.println(database.toString());
    }
}