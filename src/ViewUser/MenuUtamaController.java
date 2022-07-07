package ViewUser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import Model.OpenScene;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuUtamaController implements Initializable {

    OpenScene bukaScene = new OpenScene();

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField tfCari;

    @FXML
    private void cariButton(ActionEvent event) throws IOException {

    }

    @FXML
    private void ProfilButton(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Profil.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
        System.out.println("Profil's Button Clicked");
    }

    @FXML
    private void ZakatButton(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Zakat.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
        System.out.println("Zakat's Button Clicked");
    }

    @FXML
    private void InfaqButton(ActionEvent event) throws IOException {
        Pane halaman = bukaScene.getPane("/ViewUser/Infaq");
        mainPane.setCenter(halaman);
        System.out.println("Infaq's Button Clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
