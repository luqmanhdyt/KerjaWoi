package Model;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import ViewUser.AmalBaikProject;

public class OpenScene {

    private Pane halaman;

    public Pane getPane(String namaFile) {
        try {
            URL fileHalaman = AmalBaikProject.class.getResource(namaFile + ".fxml");
            if (fileHalaman == null) {
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }

            halaman = FXMLLoader.load(fileHalaman);
        } catch (Exception e) {
            System.out.println("Halaman tidak ditemukan");
        }
        return halaman;
    }
}