package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.model.Makanan;

public class DetailMenuMakananActivity extends AppCompatActivity {

    public static final String EXTRA_MENU_MAKANAN = "extra_menu_makanan" ;
    private ImageView iv_foto_makanan;
    private TextView tv_nama_makanan , tv_kategori_makanan,tv_deskripsi_makananan , tv_harga_makanan;
    private Button btn_udpate, btn_delete;
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
        btn_udpate = findViewById(R.id.act_menu_btn_update);
        btn_delete = findViewById(R.id.act_menu_btn_delete);

        final Makanan extramakanan = getIntent().getParcelableExtra(EXTRA_MENU_MAKANAN);
        if(extramakanan != null) {
            String id = extramakanan.getId_makanan();
            String foto = extramakanan.getFoto_makanan();
            String nama_makanan = extramakanan.getNama_makanan();
            String deskripsi_makanan = extramakanan.getDeskripsi_makanan();
            String kategori_makanan = extramakanan.getKategori_makanan();
            int harga_makanan = extramakanan.getHarga_makanan();

            tv_nama_makanan.setText(nama_makanan);
            tv_kategori_makanan.setText(kategori_makanan);
            tv_deskripsi_makananan.setText(deskripsi_makanan);
            tv_harga_makanan.setText(harga_makanan);
        }


        btn_udpate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailMenuMakananActivity.this, MenuUpdateActivity.class);
                intent.putExtra(MenuUpdateActivity.EXTRA_MAKANAN,extramakanan);
                startActivity(intent);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        new AlertDialog.Builder(DetailMenuMakananActivity.this)
                            .setTitle("Hapus Data")
                            .setMessage("Anda Yakin untuk menghapus data?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // kodingan na didieu buat delete
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
            }
        });
    }
}
