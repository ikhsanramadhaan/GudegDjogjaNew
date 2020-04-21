package com.example.admingudegdjogja.view.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.fragment.MenuFragment;
import com.example.admingudegdjogja.view.fragment.PesanFragment;
import com.example.admingudegdjogja.view.fragment.PesananMasukFragment;
import com.example.admingudegdjogja.view.fragment.PesananSelesaiFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public ViewPagerAdapter(@NonNull FragmentManager fm , Context context) {
        super(fm);
        this.mContext = context ;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new PesananMasukFragment();
            case 1 :
                return new PesananSelesaiFragment();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.title_pesanan_masuk);
            case 1:
                return mContext.getString(R.string.title_pesanan_selesai);
            default:
                return null;
        }
    }
}
