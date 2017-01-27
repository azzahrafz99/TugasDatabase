package smkn4bdg.radhika.com.tugasdatabase.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by root on 27/01/17.
 */

public class TableListSiswa extends RealmObject {
    @PrimaryKey
    private int id;

    private String nama;
    private String umur;

    public TableListSiswa() {
    }

    public TableListSiswa(int id, String nama, String umur) {
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
