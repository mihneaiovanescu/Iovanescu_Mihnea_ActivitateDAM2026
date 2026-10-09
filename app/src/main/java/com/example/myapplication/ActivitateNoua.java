package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitateNoua extends AppCompatActivity {

    private static final int COD_CERERE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_noua);
    }

    public void deschideActivitatea3(View view) {

        Intent intent = new Intent(
                ActivitateNoua.this,
                ActivitateRezultat.class
        );

        Bundle bundle = new Bundle();

        bundle.putString("mesaj", "Din activitatea 2");
        bundle.putInt("nr1", 30);
        bundle.putInt("nr2", 70);

        intent.putExtras(bundle);

        startActivityForResult(intent, COD_CERERE);
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == COD_CERERE &&
                resultCode == RESULT_OK &&
                data != null) {

            String mesaj = data.getStringExtra("mesajRezultat");
            int suma = data.getIntExtra("suma", 0);

            Toast.makeText(
                    this,
                    mesaj + " Suma = " + suma,
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}