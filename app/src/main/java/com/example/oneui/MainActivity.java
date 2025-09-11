package com.example.oneui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up the toolbar as the app bar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // (Optional) Set up bottom navigation listener
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            // Handle navigation item clicks
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                // TODO: Switch to home content
                return true;
            } else if (id == R.id.nav_settings) {
                // TODO: Switch to settings content
                return true;
            }
            return false;
        });
    }
}
