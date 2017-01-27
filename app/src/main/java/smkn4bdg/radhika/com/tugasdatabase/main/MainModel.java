package smkn4bdg.radhika.com.tugasdatabase.main;

/**
 * Created by root on 27/01/17.
 */

public class MainModel {
    private int id;
    private String nama, umur;

    public MainModel(int id, String nama, String umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
}
