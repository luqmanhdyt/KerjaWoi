package Model;

public class DataPengguna {
    String nama, email, password;
    
    boolean statusOnline;
    private boolean admin;
    
    public DataPengguna(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public boolean getStatusOnline() {
        return statusOnline;
    }

    public void setStatusOnline(boolean statusOnline) {
        this.statusOnline = statusOnline;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}