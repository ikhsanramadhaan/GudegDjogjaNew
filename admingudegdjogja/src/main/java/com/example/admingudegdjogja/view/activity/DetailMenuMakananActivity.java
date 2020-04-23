package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admingudegdjogja.R;

public class DetailMenuMakananActivity extends AppCompatActivity {

    public static final String EXTRA_MENU_MAKANAN = "extra_menu_makanan" ;
    private ImageView iv_foto_makanan;
    private TextView tv_nama_makanan , tv_kategori_makanan,tv_deskripsi_makananan , tv_harga_makanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu_makanan);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        iv_foto_makanan = findViewById(R.id.act_menu_makanan_foto);
        tv_nama_makanan = findViewById(R.id.act_menu_makanan_nama);
        tv_kategori_makanan = findViewById(R.id.act_menu_makanan_kategori);
        tv_deskripsi_makananan = findViewById(R.id.act_menu_makanan_deskripsi);
        tv_harga_makanan = findViewById(R.id.act_menu_makanan_harga);




    }
}
