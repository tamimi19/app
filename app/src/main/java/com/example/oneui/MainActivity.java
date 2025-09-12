package com.example.oneui;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS = "oneui_prefs";
    public static final String KEY_DARK = "pref_dark_mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // تطبيق وضع الليل المحفوظ قبل setContentView
        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        boolean dark = prefs.getBoolean(KEY_DARK, false);
        AppCompatDelegate.setDefaultNightMode(dark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // عرض HomeFragment افتراضياً
        replaceFragment(new HomeFragment());

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (id == R.id.nav_settings) {
                replaceFragment(new SettingsFragment());
                return true;
            } else if (id == R.id.nav_scroll) {
                replaceFragment(new ScrollMenuFragment());
                return true;
            }
            return false;
        });
    }

    private void replaceFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, f)
            .commit();
    }
}
