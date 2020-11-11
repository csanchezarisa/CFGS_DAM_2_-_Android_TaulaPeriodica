package com.example.taulaperidica.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.taulaperidica.R;

public class ActivityGame extends AppCompatActivity {

    // Array que emmagatsema les puntuacions màximes
    private int[] puntuacionsMaximes;

    // Constants que s'utilitzen per diferenciar entre els diferents jocs
    private final int GAME_ENCERTAR_SIMBOL = 0;
    private final int GAME_ENCERTAR_NOM = 1;
    private final int GAME_ENCERTAR_ESTAT = 2;
    private final int GAME_ENCERTAR_NUMERO = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Es personalitza la toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"black\">Taula Periòdica - Joc</font>"));

        // Es recuperan les puntuacions màximes que envía la MainActivity
        puntuacionsMaximes = getIntent().getExtras().getIntArray("puntuacionsMaximes");

        // Mostra les puntuacions en els TextView del Layout
        actualitzarTextPuntuacions();

        // Crear listeners als botons
        Button btnEncertarSimbol = (Button) findViewById(R.id.btnStartEncertarSimbol);
        btnEncertarSimbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJoc(GAME_ENCERTAR_SIMBOL);
            }
        });

        Button btnEncertarNom = (Button) findViewById(R.id.btnStartEncertarNom);
        btnEncertarNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJoc(GAME_ENCERTAR_NOM);
            }
        });

        Button btnEncertarEstat = (Button) findViewById(R.id.btnStartEncertarEstat);
        btnEncertarEstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJoc(GAME_ENCERTAR_ESTAT);
            }
        });

        Button btnEncertarNumero = (Button) findViewById(R.id.btnStartEncertarNumero);
        btnEncertarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJoc(GAME_ENCERTAR_NUMERO);
            }
        });

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

    // Escriu les puntuacions en els TextView del layout
    private void actualitzarTextPuntuacions() {

        TextView textView = (TextView) findViewById(R.id.txtPuntuacioEncertarSimbol);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_SIMBOL]);

        textView = (TextView) findViewById(R.id.txtPuntuacioEncertarNom);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_NOM]);

        textView = (TextView) findViewById(R.id.txtPuntuacioEncertarEstat);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_ESTAT]);

        textView = (TextView) findViewById(R.id.txtPuntuacioEncertarNumero);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_NUMERO]);

    }

    private void iniciarJoc(int modalitat) {

        switch (modalitat) {

            case GAME_ENCERTAR_SIMBOL:
                break;

            case GAME_ENCERTAR_NOM:
                break;

            case GAME_ENCERTAR_ESTAT:
                break;

            case GAME_ENCERTAR_NUMERO:
                break;

            default:
                return;

        }



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