package ViewUser;

import Model.DataZakat;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RiwayatZakatController implements Initializable {
    
    ObservableList dataTabel = observableArrayList();
    ArrayList<DataZakat> dataForm = new ArrayList<>();

    @FXML
    private TableView<DataZakat> tvZakat;

    @FXML
    private TableColumn<DataZakat, String> tcNama;

    @FXML
    private TableColumn<DataZakat, Double> tcNominal;

    @FXML
    private TableColumn<DataZakat, String> tcJenis;
    
    @FXML
    private void hapusButton(ActionEvent event) {
        
    TableView.TableViewSelectionModel selectionModel= tvZakat.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i=selectionModel.getSelectedIndex();
        if(i>=0){
            dataTabel.remove(i);
            dataForm.remove(i);
        
        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(dataForm);
        FileOutputStream berkasKeluar;

        try {
            byte[] data = xml.getBytes("UTF-8");
            berkasKeluar = new FileOutputStream("berkas.xml");
            berkasKeluar.write(data);
            berkasKeluar.close();
        } catch (Exception io) {
            System.out.println("Terjadi kesalahan: " + io.getMessage());
        }
            System.out.println("berhasil menghapus");   
    }
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tcJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        tcNominal.setCellValueFactory(new PropertyValueFactory<>("nominal"));
        
        openTabel();
     
        for (int i = 0; i < dataForm.size(); i++) {
            dataTabel.add(dataForm.get(i));  
        }
             
        tvZakat.setItems(dataTabel);
    }    
    
}
