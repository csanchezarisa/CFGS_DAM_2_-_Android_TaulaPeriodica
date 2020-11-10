package com.example.taulaperidica.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.taulaperidica.R;

public class ActivityGame extends AppCompatActivity {

    private int puntuacioMaxima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Es personalitza la toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"black\">Taula Periòdica - Joc</font>"));

        Bundle dades = getIntent().getExtras();
        puntuacioMaxima = dades.getInt("puntuacio") + 1;

        TextView textView = (TextView) findViewById(R.id.puntuacio);
        textView.setText(String.valueOf(puntuacioMaxima));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finalitzarIntent();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    // Mètode que s'encarrega de finalitzar l'activity, retornant la puntuació
    private void finalitzarIntent() {

        // Es crea un intent i s'introdueix la puntuació que fa referència al nombre de vegades que ha encertat
        Intent intent = new Intent();
        intent.putExtra("puntuacio", puntuacioMaxima);

        // Es finalitza l'activity retornant la puntuació
        setResult(RESULT_OK, intent);
        finish();

    }
}