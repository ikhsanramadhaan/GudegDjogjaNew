package com.example.admingudegdjogja.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.adapter.RecyclerViewPesananSelesaiAdapter;
import com.example.admingudegdjogja.view.model.Pesanan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananSelesaiFragment extends Fragment {
    private DatabaseReference database;
    private RecyclerView rv_pesanan_selesai;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pesanan> daftarPesanan;
    public PesananSelesaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pesanan_selesai, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_pesanan_selesai = (RecyclerView)view.findViewById(R.id.rv_pesanan_selesai);
        rv_pesanan_selesai.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv_pesanan_selesai.setLayoutManager(layoutManager);
        database = FirebaseDatabase.getInstance().getReference("pesanan");
        Query query = FirebaseDatabase.getInstance().getReference("pesanan")
                .orderByChild("pesanan_status")
                .equalTo("S");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                daftarPesanan = new ArrayList<>();
                for (DataSnapshot nodeDataSnapshot : dataSnapshot.getChildren()){
                    Pesanan pesanan = nodeDataSnapshot.getValue(Pesanan.class);
                    pesanan.setPesanan_id(nodeDataSnapshot.getKey());
                    daftarPesanan.add(pesanan);
                }
                adapter = new RecyclerViewPesananSelesaiAdapter(daftarPesanan,getContext());
                adapter.notifyDataSetChanged();
                rv_pesanan_selesai.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
