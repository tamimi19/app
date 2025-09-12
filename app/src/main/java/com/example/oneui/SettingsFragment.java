package com.example.oneui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class SettingsFragment extends Fragment {

    private SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        prefs = requireActivity().getSharedPreferences(MainActivity.PREFS, getActivity().MODE_PRIVATE);

        // Dark mode switch
        SwitchCompat darkSwitch = root.findViewById(R.id.switch_dark);
        boolean isDark = prefs.getBoolean(MainActivity.KEY_DARK, false);
        darkSwitch.setChecked(isDark);
        darkSwitch.setOnCheckedChangeListener((v, checked) -> {
            prefs.edit().putBoolean(MainActivity.KEY_DARK, checked).apply();
            AppCompatDelegate.setDefaultNightMode(checked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        });

        // Notifications switch
        SwitchCompat notifySwitch = root.findViewById(R.id.switch_notifications);
        boolean notifications = prefs.getBoolean("pref_notifications", true);
        notifySwitch.setChecked(notifications);
        notifySwitch.setOnCheckedChangeListener((c, checked) -> {
            prefs.edit().putBoolean("pref_notifications", checked).apply();
        });

        // Language spinner
        Spinner spinner = root.findViewById(R.id.spinner_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.language_entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        String cur = prefs.getString("pref_language", "en");
        spinner.setSelection(cur.equals("ar") ? 1 : 0);
        spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                String val = (position == 1) ? "ar" : "en";
                prefs.edit().putString("pref_language", val).apply();
            }
            @Override public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });

        // مثال على بطاقة (يمكن استخدامها لعرض اسم المستخدم أو إعدادات أخرى)
        MaterialCardView dummyCard = root.findViewById(R.id.card_example);

        return root;
    }
}
