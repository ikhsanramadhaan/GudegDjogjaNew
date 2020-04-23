package com.example.admingudegdjogja.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.model.Makanan;
import com.example.admingudegdjogja.view.model.uploadinfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MenuTambahActivity extends AppCompatActivity {
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    private EditText et_nama_makanan, et_deskripsi_makanan, et_harga_makanan;
    private Spinner sp_kategori_makanan;
    private ImageView iv_foto_makanan ,iv_update_foto;
    private Makanan extraMakanan;
    private Button btn_simpan;
    private  String kategori_tambah,nama_makanan_baru,deskripsi_makanan_baru,harga_makanan_baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tambah);

        setTitle(getString(R.string.title_tambah_menu));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_nama_makanan = findViewById(R.id.act_menu_tambah_makanan_nama);
        et_deskripsi_makanan = findViewById(R.id.act_menu_tambah_makanan_deskripsi);
        et_harga_makanan = findViewById(R.id.act_menu_tambah_makanan_harga);
        iv_foto_makanan = findViewById(R.id.act_menu_tambah_makanan_foto);
        iv_update_foto = findViewById(R.id.menu_ubah_foto);
        sp_kategori_makanan = findViewById(R.id.act_menu_tambah_makanan_kategori);
        btn_simpan = findViewById(R.id.act_menu_tambah_btn_tambah);

        ArrayList<String> kategori = new ArrayList<>();
        kategori.add("Menu 10 k");
        kategori.add("Tambahan");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kategori);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_kategori_makanan.setAdapter(arrayAdapter);

        sp_kategori_makanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 kategori_tambah = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 nama_makanan_baru = et_nama_makanan.getText().toString();
                 deskripsi_makanan_baru = et_deskripsi_makanan.getText().toString();
                 harga_makanan_baru = et_harga_makanan.getText().toString();
                 int hargaMakanan = Integer.parseInt(harga_makanan_baru);
                 kategori_tambah = sp_kategori_makanan.getSelectedItem().toString();
                 UploadMakanan(nama_makanan_baru,deskripsi_makanan_baru,hargaMakanan,kategori_tambah);
                et_nama_makanan.setText("");
                et_deskripsi_makanan.setText("");
                et_harga_makanan.setText("");

            }
        });

        storageReference = FirebaseStorage.getInstance().getReference("images");
        databaseReference = FirebaseDatabase.getInstance().getReference("makanan");

        iv_update_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent.createChooser(intent,"Select Image"),Image_Request_Code);

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Request_Code && resultCode == RESULT_OK
                && data != null && data.getData() != null){
            FilePathUri = data.getData();
            try {
                Bitmap bitmap =
                        MediaStore.Images.Media.getBitmap(getContentResolver(),FilePathUri);
                        iv_foto_makanan.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String GetFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;
    }

    public void UploadMakanan(final String namaMakanan, final String deskripsi_makanan, final int harga_makanan, final String kategori_makanan){
        if(FilePathUri != null){
            StorageReference storageReference1 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));
            storageReference1.putFile(FilePathUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String TempImageName = et_nama_makanan.getText().toString().trim();
                    Toast.makeText(getApplicationContext(),"Image Uploaded",Toast.LENGTH_LONG).show();
                    @SuppressWarnings("VisibleForTests")
                    Makanan uploadMakanan = new Makanan(databaseReference.push().getKey(),namaMakanan,kategori_makanan,harga_makanan,deskripsi_makanan,taskSnapshot.getUploadSessionUri().toString());
                    String makananUploadId = databaseReference.push().getKey();
                    databaseReference.child(makananUploadId).setValue(uploadMakanan);
                    finish();
                }
            });
        }else{
            Toast.makeText(MenuTambahActivity.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();
        }

    }
}
