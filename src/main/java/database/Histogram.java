package database;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class Histogram {
    public Map<String, Integer> histogramData ;

    public Histogram() {

    }

    public Component createHistogram() throws IOException {
        JFreeChart chart = ChartFactory.createBarChart("Resultados Encuesta de Valoración", "Tipos de valoraciones", "Cantidad de valoraciones por tipos", createDataset(), PlotOrientation.VERTICAL, false, false, false);

        return new ChartPanel(chart);
    }

    private CategoryDataset createDataset() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.parseDouble(new MainDataBase().loadPositivas()), "", "Val. Positivas");
        dataset.addValue(Double.parseDouble(new MainDataBase().loadMedias()), "", "Val. Medias");
        dataset.addValue(Double.parseDouble(new MainDataBase().loadNegativas()), "", "Val. Negativas");

        return dataset;
    }
}