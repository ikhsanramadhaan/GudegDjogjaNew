package com.example.admingudegdjogja.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.adapter.RecyclerViewMenuAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {
    private RecyclerView rv_menu_10k , rv_menu_tambahan;
    private FloatingActionButton btn_fab;
    private RecyclerViewMenuAdapter adapter;

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
        rv_menu_10k = view.findViewById(R.id.id_satuan);
        btn_fab = view.findViewById(R.id.frg_menu_fab);
        adapter = new RecyclerViewMenuAdapter(getContext());

        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
