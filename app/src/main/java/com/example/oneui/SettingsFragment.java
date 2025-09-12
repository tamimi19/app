package com.example.oneui;

import android.os.Bundle;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        // الإعداد: تفعيل/تعطيل الوضع الداكن
        SwitchPreferenceCompat darkPref = findPreference("pref_dark_mode");
        if (darkPref != null) {
            darkPref.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean isDark = (Boolean) newValue;
                AppCompatDelegate.setDefaultNightMode(
                    isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                return true;
            });
        }

        // تغيير اللغة (معالج بسيط لإعادة التحميل عند التغيير)
        ListPreference langPref = findPreference("pref_language");
        if (langPref != null) {
            langPref.setOnPreferenceChangeListener((preference, newValue) -> {
                // يمكن هنا إضافة تغيير اللغة الفعلي حسب الحاجة
                return true;
            });
        }
    }
}
