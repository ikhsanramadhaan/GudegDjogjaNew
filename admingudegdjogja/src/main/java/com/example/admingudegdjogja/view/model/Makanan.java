package com.example.admingudegdjogja.view.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {
    private String id_makanan;
    private String nama_makanan;
    private String kategori_makanan;
    private String jumlah_makanan;
    private int harga_makanan;
    private String deskripsi_makanan;
    private String foto_makanan;

    public Makanan() {
    }

    public Makanan(String id_makanan, String nama_makanan, String kategori_makanan, int harga_makanan, String deskripsi_makanan, String foto_makanan) {
        this.id_makanan = id_makanan;
        this.nama_makanan = nama_makanan;
        this.kategori_makanan = kategori_makanan;
        this.harga_makanan = harga_makanan;
        this.deskripsi_makanan = deskripsi_makanan;
        this.foto_makanan = foto_makanan;
    }

    public Makanan(String id_makanan, String nama_makanan, String kategori_makanan, String jumlah_makanan, int harga_makanan, String deskripsi_makanan, String foto_makanan) {
        this.id_makanan = id_makanan;
        this.nama_makanan = nama_makanan;
        this.kategori_makanan = kategori_makanan;
        this.jumlah_makanan = jumlah_makanan;
        this.harga_makanan = harga_makanan;
        this.deskripsi_makanan = deskripsi_makanan;
        this.foto_makanan = foto_makanan;
    }

    public String getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(String id_makanan) {
        this.id_makanan = id_makanan;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public String getKategori_makanan() {
        return kategori_makanan;
    }

    public void setKategori_makanan(String kategori_makanan) {
        this.kategori_makanan = kategori_makanan;
    }

    public String getJumlah_makanan() {
        return jumlah_makanan;
    }

    public void setJumlah_makanan(String jumlah_makanan) {
        this.jumlah_makanan = jumlah_makanan;
    }

    public int getHarga_makanan() {
        return harga_makanan;
    }

    public void setHarga_makanan(int harga_makanan) {
        this.harga_makanan = harga_makanan;
    }

    public String getDeskripsi_makanan() {
        return deskripsi_makanan;
    }

    public void setDeskripsi_makanan(String deskripsi_makanan) {
        this.deskripsi_makanan = deskripsi_makanan;
    }

    public String getFoto_makanan() {
        return foto_makanan;
    }

    public void setFoto_makanan(String foto_makanan) {
        this.foto_makanan = foto_makanan;
    }

    protected Makanan(Parcel in) {
        id_makanan = in.readString();
        nama_makanan = in.readString();
        kategori_makanan = in.readString();
        jumlah_makanan = in.readString();
        harga_makanan = in.readInt();
        deskripsi_makanan = in.readString();
        foto_makanan = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_makanan);
        dest.writeString(nama_makanan);
        dest.writeString(kategori_makanan);
        dest.writeString(jumlah_makanan);
        dest.writeInt(harga_makanan);
        dest.writeString(deskripsi_makanan);
        dest.writeString(foto_makanan);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Makanan> CREATOR = new Creator<Makanan>() {
        @Override
        public Makanan createFromParcel(Parcel in) {
            return new Makanan(in);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };
}
