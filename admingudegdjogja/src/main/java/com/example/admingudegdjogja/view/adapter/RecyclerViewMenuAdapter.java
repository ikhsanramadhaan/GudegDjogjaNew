package com.example.admingudegdjogja.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerViewMenuAdapter extends RecyclerView.Adapter<RecyclerViewMenuAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Makanan> data;
    private int layoutType;

    public RecyclerViewMenuAdapter(ArrayList<Makanan> data,Context context) {
        this.data = data;
        this.context = context;
    }

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
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_menu_makanan, parent, false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        URL url = null;
        try {
            url = new URL(data.get(position).getFoto_makanan());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.imageView.setImageBitmap(bmp);
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
            imageView = itemView.findViewById(R.id.makanan_foto_menu);
            tv_nama_makanan = itemView.findViewById(R.id.makanan_nama);
            tv_desc_makanan = itemView.findViewById(R.id.textview5_menu);
            tv_harga_makanan = itemView.findViewById(R.id.makanan_harga_menu);
        }
    }
}
