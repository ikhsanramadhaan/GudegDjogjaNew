package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.admingudegdjogja.R;

public class DetailPesananMasukActivity extends AppCompatActivity {
    public static final String EXTRA_PESANAN_MASUK = "extra_pesanan_masuk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_masuk);
    }
}
