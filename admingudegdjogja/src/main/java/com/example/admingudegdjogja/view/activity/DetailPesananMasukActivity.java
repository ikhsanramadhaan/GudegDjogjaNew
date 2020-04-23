package com.example.admingudegdjogja.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.adapter.RecyclerViewPesananMasukAdapter;
import com.example.admingudegdjogja.view.model.Pesanan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailPesananMasukActivity extends AppCompatActivity {
    public static final String EXTRA_PESANAN_MASUK = "extra_pesanan_masuk";
    private TextView tv_pesanan_id, tv_pesanan_total_harga , tv_pesanan_harga_totalplus, tv_pesanan_delivery;
    private Button btn_selesai;
    private Pesanan extrapesanan;
    private RecyclerView rv_menu_makanan , rv_menu_tambahan;
    private RecyclerViewPesananMasukAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_masuk);
        setTitle(getString(R.string.title_detail_pesanan));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_pesanan_id = findViewById(R.id.act_detail_pesanan_masuk_id);
        tv_pesanan_total_harga = findViewById(R.id.act_detail_pesanan_masuk_pesanan_total_harga);
        tv_pesanan_harga_totalplus = findViewById(R.id.act_detail_pesanan_masuk_pesanan_harga_totalplus);
        tv_pesanan_delivery = findViewById(R.id.act_detail_pesanan_masuk_pesanan_harga_delivery);

        rv_menu_makanan = findViewById(R.id.act_detail_pesanan_masuk_rv_menu_makanan);
        rv_menu_tambahan = findViewById(R.id.act_detail_pesanan_masuk_rv_menu_tambahan);

        extrapesanan = getIntent().getParcelableExtra(EXTRA_PESANAN_MASUK);

        final String pesanan_id = extrapesanan.getPesanan_id();
        int pesanan_total_harga = extrapesanan.getTotal_harga();
        int pesanan_delivery = 1000;
        int pesanan_total_plus = pesanan_total_harga + pesanan_delivery;

        tv_pesanan_id.setText(pesanan_id);
        tv_pesanan_total_harga.setText(String.valueOf(pesanan_total_harga));
        tv_pesanan_delivery.setText(String.valueOf(pesanan_delivery));
        tv_pesanan_harga_totalplus.setText(String.valueOf(pesanan_total_plus));

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upPesanan(pesanan_id);
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void upPesanan(final String key){
        final DatabaseReference df = FirebaseDatabase.getInstance().getReference("pesanan");
        df.orderByChild("pesanan_status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot datas : dataSnapshot.getChildren()){
                    String pesanan_id = datas.getKey();
                    Log.i("ID Pesanan + ",pesanan_id);
                    df.child(pesanan_id).child("pesanan_status").setValue("S");
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
