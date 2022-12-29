package com.example.tugas1_2018045;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;

public class Segitiga extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        final EditText etAlas = findViewById(R.id.input_alas);
        final EditText etTinggi = findViewById(R.id.input_tinggi);
        final EditText etHasil = findViewById(R.id.output_hasil);
        final Button btnHitung = findViewById(R.id.btn_hitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputAlas = etAlas.getText().toString().trim();
                String inputTinggi = etTinggi.getText().toString().trim();
                boolean isEmptyFields = false;
                boolean isInvalidDouble = false;
                if (TextUtils.isEmpty(inputAlas)) {
                    isEmptyFields = true;
                    etAlas.setError("Panjang harus diisi");
                }
                if (TextUtils.isEmpty(inputTinggi)) {
                    isEmptyFields = true;
                    etTinggi.setError("Lebar harus diisi");
                }
                Double a = toDouble(inputAlas);
                Double t = toDouble(inputTinggi);
                if (a == null) {
                    isInvalidDouble = true;
                    etAlas.setError("Panjang harus diisi dengan angka yang valid");
                }
                if (t == null) {
                    isInvalidDouble = true;
                    etTinggi.setError("Lebar harus diisi dengan angka yang valid");
                }
                if (!isEmptyFields && !isInvalidDouble) {
                    double hasil = 0.5 * a * t;
                    etHasil.setText(String.valueOf(hasil));
                }
            }
        });
    }
    private Double toDouble(String inputLength) {
        try {
            return Double.valueOf(inputLength);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}