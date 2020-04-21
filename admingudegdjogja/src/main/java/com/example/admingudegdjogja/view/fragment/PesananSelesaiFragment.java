package com.example.admingudegdjogja.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admingudegdjogja.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesananSelesaiFragment extends Fragment {

    public PesananSelesaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesanan_selesai, container, false);
    }
}
