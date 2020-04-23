package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.model.Makanan;

import java.util.ArrayList;

public class MenuTambahActivity extends AppCompatActivity {
    private EditText et_nama_makanan, et_deskripsi_makanan, et_harga_makanan;
    private Spinner sp_kategori_makanan;
    private ImageView iv_foto_makanan ,iv_update_foto;
    private Makanan extraMakanan;
    private Button btn_simpan;
    private  String kategori_tambah,nama_makanan_baru,deskripsi_makanan_baru,harga_makanan_baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tambah);

        setTitle(getString(R.string.title_tambah_menu));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_nama_makanan = findViewById(R.id.act_menu_tambah_makanan_nama);
        et_deskripsi_makanan = findViewById(R.id.act_menu_tambah_makanan_deskripsi);
        et_harga_makanan = findViewById(R.id.act_menu_tambah_makanan_harga);
        iv_foto_makanan = findViewById(R.id.act_menu_tambah_makanan_foto);
        iv_update_foto = findViewById(R.id.menu_ubah_foto);
        sp_kategori_makanan = findViewById(R.id.act_menu_tambah_makanan_kategori);
        btn_simpan = findViewById(R.id.act_menu_tambah_btn_tambah);

        ArrayList<String> kategori = new ArrayList<>();
        kategori.add("Menu 10 k");
        kategori.add("Tambahan");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kategori);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_kategori_makanan.setAdapter(arrayAdapter);

        sp_kategori_makanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 kategori_tambah = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 nama_makanan_baru = et_nama_makanan.getText().toString();
                 deskripsi_makanan_baru = et_deskripsi_makanan.getText().toString();
                 harga_makanan_baru = et_harga_makanan.getText().toString();


            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
