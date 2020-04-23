package com.example.gudegdjogja.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.gudegdjogja.R;
import com.example.gudegdjogja.fragment.MenuUserFragment;
import com.example.gudegdjogja.fragment.RiwayatPemesananFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment = new Fragment();
    private String title = "";
    public static final String KEY_FRAGMENT = "fragment";
    public static final String KEY_TITLE = "title";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_pesanan:
                        fragment = new MenuUserFragment();
                        title = getString(R.string.title_menu_makanan);
                        break;
                    case R.id.navigation_menu:
                        fragment = new RiwayatPemesananFragment();
                        title = getString(R.string.title_menu_makanan);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                setTitle(title);

                return true;
            }
        });

        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_pesanan);
            setTitle(title);
        } else {
            fragment = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT);
            title = savedInstanceState.getString(KEY_TITLE);

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            setTitle(title);
        }
    }
}
