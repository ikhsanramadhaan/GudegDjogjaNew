package com.example.admingudegdjogja.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.activity.DetailMenuMakananActivity;
import com.example.admingudegdjogja.view.model.Makanan;

import java.util.ArrayList;

public class RecyclerViewMenuAdapter extends RecyclerView.Adapter<RecyclerViewMenuAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Makanan> data;
    private int layoutType;

    public RecyclerViewMenuAdapter(Context context) {
        this.context = context;
    }

    public void AddItem(ArrayList<Makanan> data) {
        this.data = data;
    }

    public void setLayoutType(int mLayoutType){
        this.layoutType = mLayoutType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//      holder.imageView.setImageResource(data.get(position).getFoto_makanan());
        holder.tv_nama_makanan.setText(data.get(position).getNama_makanan());
        holder.tv_desc_makanan.setText(data.get(position).getDeskripsi_makanan());
        holder.tv_harga_makanan.setText(data.get(position).getHarga_makanan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMenuMakananActivity.class);
                Makanan parcelmakanan = data.get(position);
                intent.putExtra(DetailMenuMakananActivity.EXTRA_MENU_MAKANAN , parcelmakanan );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tv_nama_makanan, tv_desc_makanan, tv_harga_makanan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.makanan_foto);
            tv_nama_makanan = itemView.findViewById(R.id.makanan_nama);
            tv_desc_makanan = itemView.findViewById(R.id.textview5);
            tv_harga_makanan = itemView.findViewById(R.id.makanan_harga);
        }
    }
}
