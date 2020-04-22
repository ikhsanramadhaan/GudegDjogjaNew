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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananSelesaiFragment extends Fragment {
    private RecyclerView rv_pesanan_selesai;
    private RecyclerViewPesananSelesaiAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pesanan> data;
    public PesananSelesaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesanan_selesai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_pesanan_selesai = view.findViewById(R.id.rv_pesanan_selesai);
        rv_pesanan_selesai.setHasFixedSize(true);
        adapter = new RecyclerViewPesananSelesaiAdapter(getContext());
        layoutManager = new LinearLayoutManager(getContext());
        rv_pesanan_selesai.setLayoutManager(layoutManager);
        rv_pesanan_selesai.setAdapter(adapter);
    }
}
