package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListZakat {
    private ObservableList<DataZakat> listData;

    public ListZakat() {
        listData = FXCollections.observableArrayList();
    }

    public ObservableList<DataZakat> getData() {
        return this.listData;
    }

    public void setData(String nama, String jenis, String nominal) {
        listData.add(new DataZakat(nama, jenis, nominal));
    }
}
