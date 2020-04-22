package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.admingudegdjogja.R;

public class DetailPesananSelesaiActivity extends AppCompatActivity {
    public static final String EXTRA_PESANAN_SELESAI = "extra_pesanan_selesai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_selesai);
    }
}
