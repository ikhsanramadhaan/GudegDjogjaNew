package com.example.admingudegdjogja.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.activity.DetailPesananMasukActivity;
import com.example.admingudegdjogja.view.model.Pesanan;

import java.util.ArrayList;

public class RecyclerViewPesananMasukAdapter extends RecyclerView.Adapter<RecyclerViewPesananMasukAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Pesanan> data;

    public RecyclerViewPesananMasukAdapter(ArrayList<Pesanan> data,Context context) {
        this.data = data;
        this.context = context;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_id, txt_nama, txt_alamat,txt_no_kontak;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.pesanan_id);
            txt_nama = itemView.findViewById(R.id.pesanan_nama);
            txt_alamat = itemView.findViewById(R.id.pesanan_alamat);
            txt_no_kontak = itemView.findViewById(R.id.pesanan_no_kontak);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_pesanan_masuk, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPesananMasukAdapter.ViewHolder holder, final int position) {
        holder.txt_id.setText((data.get(position).getPesanan_id()));
        holder.txt_nama.setText(data.get(position).getPesanan_nama());
        holder.txt_alamat.setText(data.get(position).getPesanan_alamat());
        holder.txt_no_kontak.setText(data.get(position).getPesanan_nokontak());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPesananMasukActivity.class);
                Pesanan parcePesanan = data.get(position);
                intent.putExtra(DetailPesananMasukActivity.EXTRA_PESANAN_MASUK, parcePesanan);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
