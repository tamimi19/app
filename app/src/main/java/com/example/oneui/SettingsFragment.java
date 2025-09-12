package com.example.oneui;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;

/**
 * SettingsFragment: loads preferences from res/xml/preferences.xml
 * Uses PreferenceFragmentCompat API (provided by the SESL preference artifact).
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
