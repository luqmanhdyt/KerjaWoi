package ViewUser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class PersInfaqController implements Initializable {

    XYChart.Series dataInfaq = new XYChart.Series<>();

    @FXML
    private BarChart bcInfaq;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataInfaq.getData().add(new XYChart.Data("Januari", 300));
        dataInfaq.getData().add(new XYChart.Data("Febuari", 200));
        dataInfaq.getData().add(new XYChart.Data("Maret", 500));
        dataInfaq.getData().add(new XYChart.Data("April", 350));
        dataInfaq.getData().add(new XYChart.Data("May", 400));
        dataInfaq.getData().add(new XYChart.Data("Juni", 200));
        dataInfaq.getData().add(new XYChart.Data("Juni", 150));
        dataInfaq.getData().add(new XYChart.Data("Juli", 0));

        bcInfaq.getData().addAll(dataInfaq); 
    }

}
