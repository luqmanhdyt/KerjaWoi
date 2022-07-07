package Model;

public class DataZakat {
    private String nama;
    private String jenis;
    private String nominal;
    
    public DataZakat(){
        this("","","");
    }
    
    public DataZakat(String nama, String jenis, String nominal) {
        this.nama = nama;
        this.jenis = jenis;
        this.nominal = nominal;
    }

    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
    
    
}
