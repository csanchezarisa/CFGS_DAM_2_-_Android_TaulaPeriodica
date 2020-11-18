package com.example.taulaperidica.game.modalitats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taulaperidica.R;
import com.example.taulaperidica.elements.Element;
import com.example.taulaperidica.elements.LlistatElements;
import com.google.android.material.snackbar.Snackbar;

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

        // Es cerquen els botons del layout
        Button btnSolid = (Button) findViewById(R.id.btnSolid);
        Button btnLiquid = (Button) findViewById(R.id.btnLiquid);
        Button btnSintetic = (Button) findViewById(R.id.btnSintetic);
        Button btnGas = (Button) findViewById(R.id.btnGas);

        // Es creen els listeners
        btnSolid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovarResultat("Sòlid");
            }
        });
        btnLiquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovarResultat("Líquid");
            }
        });
        btnGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovarResultat("Gas");
            }
        });
        btnSintetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovarResultat("Sintètic");
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
    private void comprovarResultat(String estatSeleccionat) {

        if (estatSeleccionat.equalsIgnoreCase(estatElementActual)) {
            partidesJugades ++;
            partidesGuanyades ++;
            puntuacio ++;
            setPuntuacions();
            snackbarEncertat();
            generaSimbol();
        }
        else {

            if (puntuacio > puntuacioMaxima)
                puntuacioMaxima = puntuacio;

            partidesJugades ++;
            puntuacio = 0;
            setPuntuacions();
            alertError();
            generaSimbol();
        }

    }


    // Mostra un snackbar en la part superior amb el missatge d'encert
    private void snackbarEncertat() {
        View parentLayout = findViewById(android.R.id.content);
        Snackbar snack = Snackbar.make(parentLayout, "HAS ENCERTAT!", Snackbar.LENGTH_LONG);

        // Forzamos el TOP
        View viewSnack = snack.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams) viewSnack.getLayoutParams();
        params.gravity = Gravity.TOP;
        viewSnack.setLayoutParams(params);

        snack.show();
    }

    // Mostra un AlertDialog informant de l'error i notificant de la resposta correcte
    private void alertError() {
        AlertDialog alerta = new AlertDialog.Builder(this).create();

        alerta.setTitle("NO ÉS CORRECTE!");
        alerta.setMessage("T'has equivocat, l'estat predeterminat de l'element " + nomElementActual + " és " + estatElementActual);

        alerta.setButton(AlertDialog.BUTTON_POSITIVE, "Acceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No fa res, només tanca l'Alert
            }
        });

        alerta.show();
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