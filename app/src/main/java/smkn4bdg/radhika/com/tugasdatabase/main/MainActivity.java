package smkn4bdg.radhika.com.tugasdatabase.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;
import smkn4bdg.radhika.com.tugasdatabase.R;
import smkn4bdg.radhika.com.tugasdatabase.realm.RealmController;
import smkn4bdg.radhika.com.tugasdatabase.realm.TableListSiswa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainInterface {

    private RecyclerView main_rc;
    private Button btnSubmit;
    private EditText etUmur, etNama;

    private LinearLayoutManager layoutManager;

    private MainAdapter adapter;
    private RealmController realmController;
    private List<MainModel> mData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realmController = new RealmController(this);

        initComponent();
        getData();
        adapter = new MainAdapter(mData, this);
        main_rc.setAdapter(adapter);
        main_rc.setLayoutManager(layoutManager);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        insert(etNama.getText().toString(),etUmur.getText().toString());
    }



    private void initComponent() {
        main_rc = (RecyclerView) findViewById(R.id.rc_main);
        layoutManager = new LinearLayoutManager(this);
        etNama = (EditText) findViewById(R.id.etNama);
        etUmur = (EditText) findViewById(R.id.etUmur);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    public void getData() {
        mData.clear();
        RealmResults<TableListSiswa> data = (RealmResults<TableListSiswa>) new RealmController(this).getAllData(TableListSiswa.class);
        for (TableListSiswa child : data) {
            mData.add(new MainModel(child.getId(), child.getNama(), child.getUmur()));
        }
    }

    private void insert(String nama, String umur) {
        if(!TextUtils.isEmpty(nama.trim()) && !TextUtils.isEmpty(umur.trim())){
            int id = (int) (System.currentTimeMillis()) / 1000;
            TableListSiswa data = new TableListSiswa(id, nama, umur);
            realmController.add(data);
            getData();
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "Input tidak valid", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDeleteClick(int id) {
        realmController.delete(TableListSiswa.class, id);
        getData();
        adapter.notifyDataSetChanged();
    }

}

