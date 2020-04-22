package com.example.admingudegdjogja.view.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String user_id;
    private String user_nama;
    private String user_alamat;
    private String user_kontak;

    public User(String user_id, String user_nama, String user_alamat, String user_kontak) {
        this.user_id = user_id;
        this.user_nama = user_nama;
        this.user_alamat = user_alamat;
        this.user_kontak = user_kontak;
    }

    protected User(Parcel in) {
        user_id = in.readString();
        user_nama = in.readString();
        user_alamat = in.readString();
        user_kontak = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeString(user_nama);
        dest.writeString(user_alamat);
        dest.writeString(user_kontak);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_nama() {
        return user_nama;
    }

    public void setUser_nama(String user_nama) {
        this.user_nama = user_nama;
    }

    public String getUser_alamat() {
        return user_alamat;
    }

    public void setUser_alamat(String user_alamat) {
        this.user_alamat = user_alamat;
    }

    public String getUser_kontak() {
        return user_kontak;
    }

    public void setUser_kontak(String user_kontak) {
        this.user_kontak = user_kontak;
    }
}
