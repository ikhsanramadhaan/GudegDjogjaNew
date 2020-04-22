package com.example.admingudegdjogja.view.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pesanan implements Parcelable {
    private String pesanan_id;
    private String pesanan_status;
    private String pesanan_nama;
    private String pesanan_alamat;
    private String pesanan_nokontak;
    private int total_harga;
    private String makanan_id;

    public Pesanan() {
    }

    public Pesanan(String pesanan_id, String pesanan_status, String pesanan_nama, String pesanan_alamat, String pesanan_nokontak, int total_harga, String makanan_id) {
        this.pesanan_id = pesanan_id;
        this.pesanan_status = pesanan_status;
        this.pesanan_nama = pesanan_nama;
        this.pesanan_alamat = pesanan_alamat;
        this.pesanan_nokontak = pesanan_nokontak;
        this.total_harga = total_harga;
        this.makanan_id = makanan_id;
    }

    public String getPesanan_id() {
        return pesanan_id;
    }

    public void setPesanan_id(String pesanan_id) {
        this.pesanan_id = pesanan_id;
    }

    public String getPesanan_status() {
        return pesanan_status;
    }

    public void setPesanan_status(String pesanan_status) {
        this.pesanan_status = pesanan_status;
    }

    public String getPesanan_nama() {
        return pesanan_nama;
    }

    public void setPesanan_nama(String pesanan_nama) {
        this.pesanan_nama = pesanan_nama;
    }

    public String getPesanan_alamat() {
        return pesanan_alamat;
    }

    public void setPesanan_alamat(String pesanan_alamat) {
        this.pesanan_alamat = pesanan_alamat;
    }

    public String getPesanan_nokontak() {
        return pesanan_nokontak;
    }

    public void setPesanan_nokontak(String pesanan_nokontak) {
        this.pesanan_nokontak = pesanan_nokontak;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public String getMakanan_id() {
        return makanan_id;
    }

    public void setMakanan_id(String makanan_id) {
        this.makanan_id = makanan_id;
    }

    protected Pesanan(Parcel in) {
        pesanan_id = in.readString();
        pesanan_status = in.readString();
        pesanan_nama = in.readString();
        pesanan_alamat = in.readString();
        pesanan_nokontak = in.readString();
        total_harga = in.readInt();
        makanan_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pesanan_id);
        dest.writeString(pesanan_status);
        dest.writeString(pesanan_nama);
        dest.writeString(pesanan_alamat);
        dest.writeString(pesanan_nokontak);
        dest.writeInt(total_harga);
        dest.writeString(makanan_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pesanan> CREATOR = new Creator<Pesanan>() {
        @Override
        public Pesanan createFromParcel(Parcel in) {
            return new Pesanan(in);
        }

        @Override
        public Pesanan[] newArray(int size) {
            return new Pesanan[size];
        }
    };
}
