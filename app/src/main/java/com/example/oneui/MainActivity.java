package com.example.oneui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private SettingsFragment settingsFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // إعداد شريط الأدوات كـ ActionBar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // تهيئة الشظايا
        settingsFragment = new SettingsFragment();
        homeFragment = new HomeFragment();

        // عرض HomeFragment بشكل افتراضي
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, homeFragment);
        transaction.commit();

        // إعداد مستمع اختيار عنصر في قائمة التنقل السفلي
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (id == R.id.nav_home) {
                // عرض المحتوى الرئيسي
                ft.replace(R.id.container, homeFragment);
            } else if (id == R.id.nav_settings) {
                // عرض شاشة الإعدادات
                ft.replace(R.id.container, settingsFragment);
            }
            ft.commit();
            return true;
        });
    }
}
