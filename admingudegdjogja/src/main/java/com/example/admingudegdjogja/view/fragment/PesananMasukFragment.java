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
import com.example.admingudegdjogja.view.adapter.RecyclerViewPesananMasukAdapter;
import com.example.admingudegdjogja.view.model.Pesanan;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananMasukFragment extends Fragment {

    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<Pesanan> dafatarPesanan;

    public PesananMasukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_pesanan_masuk, container, false);
        rvView = (RecyclerView)rootView.findViewById(R.id.rv_pesanan_masuk);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvView.setLayoutManager(layoutManager);

        database = FirebaseDatabase.getInstance().getReference();
        database.child("pesanan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dafatarPesanan = new ArrayList<>();
                for (DataSnapshot nodeDataSnapshot : dataSnapshot.getChildren()){
                    Pesanan pesanan = nodeDataSnapshot.getValue(Pesanan.class);
                    pesanan.setPesanan_id(nodeDataSnapshot.getKey());
                    dafatarPesanan.add(pesanan);
                }
                adapter = new RecyclerViewPesananMasukAdapter(dafatarPesanan,getContext());
                rvView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return rootView;
    }
}
