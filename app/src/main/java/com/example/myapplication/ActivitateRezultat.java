package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitateRezultat extends AppCompatActivity {

    int nr1;
    int nr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_rezultat);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            String mesaj = bundle.getString("mesaj");
            nr1 = bundle.getInt("nr1");
            nr2 = bundle.getInt("nr2");

            Toast.makeText(
                    this,
                    mesaj + " " + nr1 + " " + nr2,
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    public void trimiteInapoi(View view) {

        int suma = nr1 + nr2;

        Intent intent = new Intent();

        intent.putExtra(
                "mesajRezultat",
                "Rezultat primit:"
        );

        intent.putExtra("suma", suma);

        setResult(RESULT_OK, intent);

        finish();
    }
}