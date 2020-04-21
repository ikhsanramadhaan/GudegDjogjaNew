package com.example.admingudegdjogja.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admingudegdjogja.R;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_login = findViewById(R.id.act_main_button_login);
        editTextUsername = findViewById(R.id.act_main_edittext_username);
        editTextPassword = findViewById(R.id.act_main_edittext_password);


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUsername.getText().toString().equalsIgnoreCase("") && editTextPassword.getText().
                        toString().equalsIgnoreCase( "")){
                    Intent intent = new Intent(MainActivity.this , HomeActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
