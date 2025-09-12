package com.example.oneui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.preference.PreferenceManager;
import android.view.MenuItem;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

/**
 * MainActivity: شاشة رئيسية تحتوي على درج تنقل (Navigation Drawer) للتنقل بين:
 * - HomeFragment (الرئيسية)
 * - ScrollListFragment (قائمة التمرير)
 * - SettingsFragment (الإعدادات)
 * تم ضبط Theme وتغيير اللغة في بداية onCreate حسب تفضيلات المستخدم.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // استرجاع إعدادات الثيم (داكن/فاتح) واللغة
        boolean darkMode = PreferenceManager.getDefaultSharedPreferences(this)
            .getBoolean("dark_mode", false);
        if (darkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        String language = PreferenceManager.getDefaultSharedPreferences(this)
            .getString("language", "english");
        // تطبيق اللغة المختارة (بسيط)
        if ("arabic".equals(language)) {
            LocaleHelper.setLocale(this, "ar");
        } else {
            LocaleHelper.setLocale(this, "en");
        }

        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);

        // إعداد شريط الأدوات كـ ActionBar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // تفعيل أيقونة الهامبرغر لفتح درج التنقل
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // إعداد مستمع اختيارات القائمة
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        // تحميل الشاشة الافتراضية (HomeFragment)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new HomeFragment())
                    .commit();
            navView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // التعامل مع خيارات القائمة في درج التنقل
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new HomeFragment())
                    .commit();
        } else if (id == R.id.nav_scroll_list) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new ScrollListFragment())
                    .commit();
        } else if (id == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new SettingsFragment())
                    .commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
