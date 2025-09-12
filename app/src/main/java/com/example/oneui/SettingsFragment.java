package com.example.oneui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

/**
 * SettingsFragment: شاشة الإعدادات. تقوم بتحميل تفضيلات XML وتطبيق التغييرات.
 * - dark_mode: تبديل الوضع الداكن/الفاتح عبر AppCompatDelegate.
 * - language: قائمة اختيار اللغة؛ يعيد ضبط locale وإعادة إنشاء النشاط.
 * - notifications: مفتاح لتفعيل/تعطيل الإشعارات (هنا يبقى كاختيار وهمي).
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        // مفتاح الوضع الداكن
        SwitchPreferenceCompat darkModePref = findPreference("dark_mode");
        if (darkModePref != null) {
            darkModePref.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean on = (boolean) newValue;
                if (on) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                return true;
            });
        }

        // خيار اللغة
        ListPreference languagePref = findPreference("language");
        if (languagePref != null) {
            languagePref.setOnPreferenceChangeListener((preference, newValue) -> {
                String locale = (String) newValue;
                if ("arabic".equals(locale)) {
                    LocaleHelper.setLocale(getContext(), "ar");
                } else {
                    LocaleHelper.setLocale(getContext(), "en");
                }
                // إعادة إنشاء النشاط لتطبيق اللغة
                if (getActivity() != null) getActivity().recreate();
                return true;
            });
        }

        // مفتاح الإشعارات (هنا يتعامل فقط كإعداد وهمي)
        Preference notificationsPref = findPreference("notifications");
        if (notificationsPref != null) {
            notificationsPref.setOnPreferenceChangeListener((preference, newValue) -> {
                // يمكن إضافة منطق تفعيل الإشعارات هنا
                return true;
            });
        }
    }
}
