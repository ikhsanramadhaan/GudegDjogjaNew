package com.example.admingudegdjogja.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesanFragment extends Fragment {

    public PesanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tableLayout = view.findViewById(R.id.home_tablayout);
        ViewPager viewPager = view.findViewById(R.id.home_viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), getContext()));
        tableLayout.setupWithViewPager(viewPager);
    }
}
