package com.example.admingudegdjogja.view.fragment;

import android.content.Intent;
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
import com.example.admingudegdjogja.view.activity.MenuTambahActivity;
import com.example.admingudegdjogja.view.adapter.RecyclerViewMenuAdapter;
import com.example.admingudegdjogja.view.adapter.RecyclerViewPesananSelesaiAdapter;
import com.example.admingudegdjogja.view.model.Makanan;
import com.example.admingudegdjogja.view.model.Pesanan;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
public class MenuFragment extends Fragment {
    private RecyclerView rv_menu_10k , rv_menu_tambahan;
    private FloatingActionButton btn_fab;
    private DatabaseReference database;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Makanan> daftarMakanan;
    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_menu_10k = view.findViewById(R.id.id_menu_10_k);
        rv_menu_tambahan = view.findViewById(R.id.id_satuan);
        btn_fab = view.findViewById(R.id.frg_menu_fab);
        adapter = new RecyclerViewMenuAdapter(getContext());
        rv_menu_10k.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv_menu_10k.setLayoutManager(layoutManager);
        database = FirebaseDatabase.getInstance().getReference("makanan");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                daftarMakanan = new ArrayList<>();
                for (DataSnapshot nodeDataSnapshot : dataSnapshot.getChildren()){
                    Makanan makanan = nodeDataSnapshot.getValue(Makanan.class);
                    makanan.setId_makanan(nodeDataSnapshot.getKey());
                    daftarMakanan.add(makanan);
                }
                adapter = new RecyclerViewMenuAdapter(daftarMakanan,getContext());
                adapter.notifyDataSetChanged();
                rv_menu_10k.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MenuTambahActivity.class);
                startActivity(intent);
            }
        });
    }
}
