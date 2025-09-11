package com.example.oneui; // عدِّل اسم الحزمة بحسب مشروعك

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;

/**
 * SettingsFragment: extends PreferenceFragmentCompat to display the settings.
 * We use One UI SESL PreferenceFragmentCompat to load preferences from XML.
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Load preferences from the XML resource (res/xml/preferences.xml)
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
