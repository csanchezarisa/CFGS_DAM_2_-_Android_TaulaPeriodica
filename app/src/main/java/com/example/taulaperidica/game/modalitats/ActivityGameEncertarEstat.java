package com.example.taulaperidica.game.modalitats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taulaperidica.R;
import com.example.taulaperidica.elements.Element;
import com.example.taulaperidica.elements.LlistatElements;

public class ActivityGameEncertarEstat extends AppCompatActivity {


    // Comptador que emmagatzema el nombre de cops que guanya
    private int puntuacio = 0;

    // Emmagatzema la puntuació màxima que s'ha aconseguit en el joc
    private int puntuacioMaxima;

    // Comptador de partides guanyades i de partides jugades, que es retornarà a l'activity principal del joc
    private int partidesJugades;
    private int partidesGuanyades;

    // Emmagatzema les dades necesàries per identificar l'element actual
    private String estatElementActual;
    private String nomElementActual;

    // Llistat amb els elements
    Element[] elements = LlistatElements.elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_encertar_estat);

        // S'inicialitzen els comptadors a 0
        partidesGuanyades = 0;
        partidesJugades = 0;

        // Es recupera la puntuació màxima d'aquesta modalitat de joc
        puntuacioMaxima = getIntent().getExtras().getInt("puntuacio");

        // Es personalitza la toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"black\">Taula Periòdica - Joc</font>"));

        // Actualitza el layout per visualitzar les puntuacions
        setPuntuacions();

        // Recupera un element de manera random i mostra el seu símbol
        generaSimbol();

        // Listener pel botó d'acceptar
        Button btnAcceptar = (Button) findViewById(R.id.btnAcceptar);
        btnAcceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovarResultat();
            }
        });

    }

    // Revisa si es fa clic en el botó per tornar endarrera
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finalitzarIntent();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    // Escolta quan la tecla per tornar endarrera
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finalitzarIntent();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    // Actualitza el layout per visualitzar les puntuacions
    private void setPuntuacions() {

        TextView textView = (TextView) findViewById(R.id.txtPuntuacioActual);
        textView.setText("Puntuació: " + puntuacio);

        textView = (TextView) findViewById(R.id.txtPuntuacioMaxima);
        textView.setText("Puntuació màxima: " + puntuacioMaxima);

    }

    // Recupera un element de manera random i mostra el seu símbol
    private void generaSimbol() {
        // Es genera un número random dins del rang d'elements que hi ha
        int posicioLlistat = (int) (Math.random() * (elements.length - 1));

        // S'aconsegueix el nom i el símbol de l'element
        nomElementActual = elements[posicioLlistat].getNom();
        estatElementActual = elements[posicioLlistat].getEstatPredeterminat();

        TextView textView = (TextView) findViewById(R.id.txtNomElement);
        textView.setText(nomElementActual);
    }

    // Comprova si el l'element introduit dins del dialog és el mateix que el que s'està mostrant
    private void comprovarResultat() {
        EditText input = (EditText) findViewById(R.id.edtEstatElement);

        if (input.getText().toString().length() > 0) {

            if (input.getText().toString().equalsIgnoreCase(estatElementActual)) {
                partidesJugades ++;
                partidesGuanyades ++;
                puntuacio ++;
                setPuntuacions();
                generaSimbol();
                Toast.makeText(getApplicationContext(), "HAS ENCERTAT!", Toast.LENGTH_LONG).show();
            }
            else {

                if (puntuacio > puntuacioMaxima)
                    puntuacioMaxima = puntuacio;

                partidesJugades ++;
                puntuacio = 0;
                setPuntuacions();
                Toast.makeText(getApplicationContext(), "T'HAS EQUIVOCAT, L'ESTAT ERA " + estatElementActual.toUpperCase() + "!", Toast.LENGTH_LONG).show();

                generaSimbol();

            }

        }
        else {
            Toast.makeText(getApplicationContext(), "INTRODUEIX UN NOM!", Toast.LENGTH_LONG).show();
        }

        input.setText("");
        input.clearFocus();

    }

    // Mètode que s'encarrega de finalitzar l'activity, retornant la puntuació
    private void finalitzarIntent() {

        // Es revisa si la puntuació actual és més gran que la màxima que es té enregistrada
        if (puntuacio > puntuacioMaxima)
            puntuacioMaxima = puntuacio;

        // Es crea un intent i les puntuacions màximes
        Intent intent = new Intent();
        intent.putExtra("puntuacio", puntuacioMaxima);
        intent.putExtra("partidesGuanyades", partidesGuanyades);
        intent.putExtra("partidesJugades", partidesJugades);

        // Es finalitza l'activity retornant la puntuació
        setResult(RESULT_OK, intent);
        finish();

    }

}