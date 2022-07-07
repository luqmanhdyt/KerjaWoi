package ViewUser;

import Model.OpenScene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProfilController implements Initializable {

    OpenScene bukaScene = new OpenScene();

    @FXML
    private BorderPane mainPane;

    @FXML
    private void BalikButton(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MenuUtama.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void KtgInfaqButton(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("/ViewUser/KtgInfaq");
        mainPane.setCenter(halaman);
        System.out.println("KtgInfaq's Button Clicked");
    }

    @FXML
    private void PersInfaqButton(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("/ViewUser/PersInfaq");
        mainPane.setCenter(halaman);
        System.out.println("PersInfaq's Button Clicked");
    }
    
    @FXML
    private void RiwayatButton(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("/ViewUser/RiwayatZakat");
        mainPane.setCenter(halaman);
        System.out.println("Riwayat Zakat's Button Clicked");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
