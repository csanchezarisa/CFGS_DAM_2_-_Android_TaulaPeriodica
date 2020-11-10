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

    private int[] puntuacionsMaximes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Es personalitza la toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"black\">Taula Periòdica - Joc</font>"));

        // Es recuperan les puntuacions màximes que envía la MainActivity
        puntuacionsMaximes = getIntent().getExtras().getIntArray("puntuacionsMaximes");


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

        // Es crea un bundle amb les puntuacions màximes que s'han obtingut
        Bundle puntuacions = new Bundle();
        puntuacions.putIntArray("puntuacionsMaximes", puntuacionsMaximes);

        // Es crea un intent i les puntuacions màximes
        Intent intent = new Intent();
        intent.putExtras(puntuacions);

        // Es finalitza l'activity retornant la puntuació
        setResult(RESULT_OK, intent);
        finish();

    }
}