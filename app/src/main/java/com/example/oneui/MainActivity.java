package com.example.oneui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // عرض رسالة ترحيب عند بدء التطبيق
        Toast.makeText(this, getString(R.string.welcome_message), Toast.LENGTH_SHORT).show();

        // إعداد شريط الأدوات كـ ActionBar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // إعداد مستمع لأحداث الانتقال في التنقل السفلي
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                // الرجوع إلى الشاشة الرئيسية (إزالة fragment الإعدادات إن وجدت)
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                }
                return true;
            } else if (id == R.id.nav_settings) {
                // الانتقال إلى شاشة الإعدادات
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new SettingsFragment())
                    .addToBackStack(null)
                    .commit();
                return true;
            }
            return false;
        });
    }
}
