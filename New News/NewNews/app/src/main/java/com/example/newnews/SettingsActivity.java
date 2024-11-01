package com.example.newnews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    // deklarasi komponen
    String resultText;
    Spinner spinnerCountry, spinnerLanguage;
    Button btnSaveSettings;
    TextView txt_result;
    Switch switchTheme, switchAdultFilter, switchNotification;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);  // Pastikan nama file layout sesuai

        // Inisialisasi Spinner Bahasa
        Spinner languageSpinner = findViewById(R.id.spinnerLanguage);
        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(this,
                R.array.language_list, android.R.layout.simple_spinner_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(languageAdapter);

        // Inisialisasi Spinner Negara
        Spinner countrySpinner = findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this,
                R.array.country_list, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);

        // inisialisasi komponen
        btnSaveSettings = findViewById(R.id.btnSaveSetting);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        txt_result = findViewById(R.id.txt_result);
        switchAdultFilter = findViewById(R.id.switchAdultFilter);
        switchNotification = findViewById(R.id.switchNotification);
        switchTheme = findViewById(R.id.switchTheme);

        // event click button submit
        btnSaveSettings.setOnClickListener(view -> {
            this.getResult();
        });
    }
    private void getResult()
    {
        resultText = "Hasil Output \n";
        txt_result.setText(resultText);

        // get text dari pilihan spinner
        resultText += "\nBahasa : " + spinnerLanguage.getSelectedItem().toString();

        // get isChecked dari switch
        resultText += "\nTema : ";
        if(switchTheme.isChecked()){ resultText += "Gelap"; } else { resultText += "Terang"; }

        // get text dari pilihan spinner
        resultText += "\nNegara : " + spinnerCountry.getSelectedItem().toString();

        // get isChecked dari switch
        resultText += "\nFilter Konter Dewasa : ";
        if(switchAdultFilter.isChecked()){ resultText += "Aktif"; } else { resultText += "Tidak Aktif"; }

        // get isChecked dari switch
        resultText += "\nNotifikasi : ";
        if(switchNotification.isChecked()){ resultText += "Gelap"; } else { resultText += "Terang"; }

        // tampilkan result nya
        txt_result.setText(resultText);
    }
}

