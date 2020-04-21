package com.example.admingudegdjogja.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.admingudegdjogja.R;
import com.example.admingudegdjogja.view.fragment.MenuFragment;
import com.example.admingudegdjogja.view.fragment.PesanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private String title = "";
    private Fragment fragment = new Fragment();
    public static final String KEY_TITLE = "title";
    public static final String KEY_FRAGMENT = "fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_pesanan:
                        fragment = new PesanFragment();
                        title = getString(R.string.title_pesanan);
                        break;
                    case R.id.navigation_menu:
                        fragment = new MenuFragment();
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
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_TITLE, title);
        getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT, fragment);
        super.onSaveInstanceState(outState);
    }
}
