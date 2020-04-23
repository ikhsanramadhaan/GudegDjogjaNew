package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.adapter.RecyclerViewPesananSelesaiAdapter;
import com.example.admingudegdjogja.view.model.Pesanan;

public class DetailPesananSelesaiActivity extends AppCompatActivity {
    public static final String EXTRA_PESANAN_SELESAI = "extra_pesanan_selesai";
    private TextView tv_pesanan_id, tv_pesanan_total_harga , tv_pesanan_harga_totalplus, tv_pesanan_delivery;

    private Pesanan extrapesanan;
    private RecyclerView rv_menu_makanan , rv_menu_tambahan;
    private RecyclerViewPesananSelesaiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_selesai);

        setTitle(getString(R.string.title_detail_pesanan));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_pesanan_id = findViewById(R.id.act_detail_pesanan_selesai_pesanan_id);
        tv_pesanan_total_harga = findViewById(R.id.act_detail_pesanan_selesai_pesanan_total_harga);
        tv_pesanan_harga_totalplus = findViewById(R.id.act_detail_pesanan_selesai_pesanan_harga_totalplus);
        tv_pesanan_delivery = findViewById(R.id.act_detail_pesanan_selesai_pesanan_harga_delivery);
        rv_menu_makanan = findViewById(R.id.act_detail_pesanan_selesai_pesanan_main_menu);
        rv_menu_tambahan = findViewById(R.id.act_detail_pesanan_selesai_pesanan_tambahan_menu);


        extrapesanan = getIntent().getParcelableExtra(EXTRA_PESANAN_SELESAI);
        String pesanan_id = extrapesanan.getPesanan_id();
        int pesanan_total_harga = extrapesanan.getTotal_harga();
        int pesanan_delivery = 1000;
        int pesanan_total_plus = pesanan_total_harga + pesanan_delivery;

        tv_pesanan_id.setText(pesanan_id);
        tv_pesanan_total_harga.setText(String.valueOf(pesanan_total_harga));
        tv_pesanan_delivery.setText(String.valueOf(pesanan_delivery));
        tv_pesanan_harga_totalplus.setText(String.valueOf(pesanan_total_plus));
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
