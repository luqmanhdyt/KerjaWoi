package ViewUser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.DataZakat;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ZakatController implements Initializable {

    ArrayList<DataZakat> dataForm = new ArrayList<DataZakat>();
    DataZakat dataZkt;
    
    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfNominal;

    @FXML
    private ChoiceBox cbJenis;

    @FXML
    private void BalikButton(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MenuUtama.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    void openTabel() {
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("berkas.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            dataForm = (ArrayList<DataZakat>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    @FXML
    private void BayarZakatButton(ActionEvent event) {
                
        openTabel();

        XStream xstream = new XStream(new StaxDriver());
        String nama = tfNama.getText();
        String nominal = tfNominal.getText();
        String jenis = "";
        if (cbJenis.getValue().equals("Zakat Maal")) {
            jenis = "Zakat Maal";
        } else if (cbJenis.getValue().equals("Zakat Profesi")) {
            jenis = "Zakat Profesi";   
        } else {

        }
        dataForm.add(new DataZakat(nama, jenis, nominal));
        
        System.out.println(dataForm.get(0).getNama());


        String xml = xstream.toXML(dataForm);
        FileOutputStream berkasKeluar;

        try {
            byte[] info = xml.getBytes("UTF-8");
            berkasKeluar = new FileOutputStream("berkas.xml");
            berkasKeluar.write(info);
            berkasKeluar.close();

        } catch (Exception io) {
            System.out.println("Terjadi kesalahan : " + io.getMessage());
        }

        System.out.println("CreateButton is clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openTabel();
        dataZkt = new DataZakat();
        cbJenis.getItems().addAll("Zakat Maal", "Zakat Profesi");
        cbJenis.setValue("Zakat Maal");
//        cbJenis.setValue("Zakat Profesi");
    }

}
