package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MenuUpdateActivity extends AppCompatActivity {

    public static final String EXTRA_MAKANAN = "extra_makanan" ;
    private EditText et_nama_makanan, et_deskripsi_makanan, et_harga_makanan;
    private Spinner sp_kategori_makanan;
    private ImageView iv_foto_makanan ,iv_update_foto;
    private Makanan extraMakanan;
    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_update);

        setTitle(getString(R.string.title_update_menu));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_nama_makanan = findViewById(R.id.act_menu_update_makanan_nama);
        et_deskripsi_makanan = findViewById(R.id.act_menu_update_makanan_deskripsi);
        et_harga_makanan = findViewById(R.id.act_menu_update_makanan_harga);
        iv_foto_makanan = findViewById(R.id.act_menu_update_makanan_foto);
        iv_update_foto = findViewById(R.id.menu_ubah_foto);
        sp_kategori_makanan = findViewById(R.id.act_menu_update_makanan_kategori);
        btn_update = findViewById(R.id.act_menu_update_btn_update);

        extraMakanan =getIntent().getParcelableExtra(EXTRA_MAKANAN);

            String id = extraMakanan.getId_makanan();
            String foto = extraMakanan.getFoto_makanan();
            String nama_makanan = extraMakanan.getNama_makanan();
            String deskripsi_makanan = extraMakanan.getDeskripsi_makanan();
            String kategori_makanan = extraMakanan.getKategori_makanan();
            int harga_makanan = extraMakanan.getHarga_makanan();
            int spinnerposisi = Integer.parseInt(kategori_makanan);
            sp_kategori_makanan.setSelection(spinnerposisi);

            et_nama_makanan.setText(nama_makanan);
            et_deskripsi_makanan.setText(deskripsi_makanan);
            et_harga_makanan.setText(harga_makanan);

            ArrayList<String> kategori = new ArrayList<>();
            kategori.add("Menu 10 k");
            kategori.add("Tambahan");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kategori);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp_kategori_makanan.setAdapter(arrayAdapter);

            sp_kategori_makanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String kategori = parent.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nama_makanan_baru = et_nama_makanan.getText().toString();
                    String deskripsi_makanan_baru = et_deskripsi_makanan.getText().toString();
                    String harga_makanan_baru = et_harga_makanan.getText().toString();
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
