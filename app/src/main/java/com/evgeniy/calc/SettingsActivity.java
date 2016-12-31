package com.evgeniy.calc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;


public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final String APP_PREFERENCES_ThemeLight = "themeLight";

        final String APP_PREFERENCES_ThemeDark = "themeDark";

        final SharedPreferences settingsThemeLight = getSharedPreferences(APP_PREFERENCES_ThemeLight, MODE_PRIVATE);

        final SharedPreferences settingsThemeDark = getSharedPreferences(APP_PREFERENCES_ThemeDark, MODE_PRIVATE);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupTheme);

        final RadioButton radioButtonLight = (RadioButton) findViewById(R.id.radioButtonLight);

        final RadioButton radioButtonDark = (RadioButton) findViewById(R.id.radioButtonDark);

        radioButtonLight.setChecked(settingsThemeLight.getBoolean(APP_PREFERENCES_ThemeLight, true));

        radioButtonDark.setChecked(settingsThemeDark.getBoolean(APP_PREFERENCES_ThemeDark, false));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonLight:
                        break;

                    case R.id.radioButtonDark:
                        break;
                }

                SharedPreferences.Editor editorLight = settingsThemeLight.edit();

                editorLight.putBoolean(APP_PREFERENCES_ThemeLight, radioButtonLight.isChecked());

                editorLight.apply();

                SharedPreferences.Editor editorDark = settingsThemeDark.edit();

                editorDark.putBoolean(APP_PREFERENCES_ThemeDark, radioButtonDark.isChecked());

                editorDark.apply();
            }
        });

        Switch switchSave = (Switch) findViewById(R.id.switchSave);

        switchSave.setChecked(MainActivity.settingsSaveValue.getBoolean(MainActivity.APP_PREFERENCES_SaveValue, true));

        switchSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editorSaveValue = MainActivity.settingsSaveValue.edit();

                editorSaveValue.putBoolean(MainActivity.APP_PREFERENCES_SaveValue, isChecked);

                editorSaveValue.apply();

                MainActivity.saveValue = isChecked;
            }
        });
    }
}
