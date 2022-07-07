package ViewUser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Model.DataPengguna;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuatAkunController implements Initializable {

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Label masihKosong;

    @FXML
    private Label emailSama;

    LinkedList<DataPengguna> dataRegistration = new LinkedList<>(); //inisialisasi LinkedList untuk  menyimpan Pengguna yang dibutuhkan saat login
    //setiap node memiliki masing-masing Pengguna

    LinkedList<DataPengguna> getLoginData() {
        return dataRegistration;
    }

    DataPengguna getUserOnline() {
        for (int i = 0; i < dataRegistration.size(); i++) {
            if (dataRegistration.get(i).getStatusOnline()) {
                return dataRegistration.get(i);
            }
        }
        return null;
    }

    XStream xstream = new XStream(new StaxDriver());

    void bukaXML() {
        FileInputStream buka = null;
        try {
            // nama file yang akan dibuka (termasuk folder jika perlu
            buka = new FileInputStream("dataRegistration.xml");
            // harus diingat objek apa yang dahulu disimpan di file 
            // program untuk membaca harus sinkron dengan program
            // yang dahulu digunakan untuk menyimpannya
            int isi;
            char c;
            // isi file dikembalikan menjadi string
            String s = "";

            while ((isi = buka.read()) != -1) {
                c = (char) isi;
                s = s + c;
            }

            // string isi file dikembalikan menjadi larik double
            dataRegistration = (LinkedList<DataPengguna>) xstream.fromXML(s);
        } catch (Exception e) {
            System.err.println("test : " + e.getMessage());
        } finally {
            if (buka != null) {
                try {
                    buka.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML
    private void daftarButton(ActionEvent event) throws IOException {

        //mengambil text dari masing-masing textfield untuk dimasukkan dalam variabel
        String nama = tfNama.getText();
        String email = tfEmail.getText();
        String pass = pfPassword.getText();

        boolean similarEmail = false; //variabel digunakan untuk mengecek apakah ada ID yang sama (telah digunakan)

        //Melakukan pencarian terhadap tiap index di Linked List untuk mendapatkan email pada setiap index
        for (int i = 0; i < dataRegistration.size(); i++) {
            System.out.println(dataRegistration.get(i));
            if (email.equals(dataRegistration.get(i).getEmail())) {
                /*Jika Email yang didaftatkan, 
                ditemukan kesamaan dengan email yg telah terdaftar sebelumnya, maka variabel similarEmail == true */
                similarEmail = true; //similarEmail set True (Terdapat email yang sama antara yg terdaftar dengan yg telah terdaftar seblmnya)
            }
        }

        if (similarEmail) {
            emailSama.setText("Email telah digunakan"); //Muncul apabila email yang didaftarkan, telah terdaftar sebelumnya (sama)
            System.out.println("Email telah digunakan");
        } else if (!similarEmail) {
            dataRegistration.add(new DataPengguna(nama, email, pass));
            /*Jika tidak terdapat Email yang sama, data akan disimpan ke dalam
                LinkedList dataRegistration*/

            // larik double diubah menjadi string dengan format XML
            String xml = xstream.toXML(dataRegistration);
            FileOutputStream berkasBaru = null;
            try {
                // membuat nama file & folder tempat menyimpan jika perlu
                berkasBaru = new FileOutputStream("dataRegistration.xml");

                // mengubah karakter penyusun string xml sebagai 
                // bytes (berbentuk nomor2 kode ASCII
                byte[] bytes = xml.getBytes("UTF-8");

                //Menyimpan file dari bytes
                berkasBaru.write(bytes);
            } catch (Exception e) {
                System.err.println("Perhatian : " + e.getMessage());
            } finally {
                if (berkasBaru != null) {
                    try {
                        berkasBaru.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Masuk.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bukaXML();
    }

}
