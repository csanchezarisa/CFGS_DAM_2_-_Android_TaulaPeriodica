package com.example.taulaperidica.game;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.taulaperidica.R;
import com.example.taulaperidica.game.modalitats.ActivityGameEncertarEstat;
import com.example.taulaperidica.game.modalitats.ActivityGameEncertarNom;
import com.example.taulaperidica.game.modalitats.ActivityGameEncertarNumero;
import com.example.taulaperidica.game.modalitats.ActivityGameEncertarSimbol;

public class ActivityGame extends AppCompatActivity {

    // Array que emmagatsema les puntuacions màximes
    private int[] puntuacionsMaximes;

    // Emmagatzemen el valor de partides guanyades i jugades per poder mostrar el gràfic
    private int partidesJugades;
    private int partidesGuanyades;

    // Constants que s'utilitzen per diferenciar entre els diferents jocs
    private final int GAME_ENCERTAR_SIMBOL = 0;
    private final int GAME_ENCERTAR_NOM = 1;
    private final int GAME_ENCERTAR_ESTAT = 2;
    private final int GAME_ENCERTAR_NUMERO = 3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Es personalitza la toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"black\">Taula Periòdica - Joc</font>"));

        // Es recuperan les puntuacions màximes que envía la MainActivity, juntament amb les partides jugades i guanyades per dibuixar la gràfica
        puntuacionsMaximes = getIntent().getExtras().getIntArray("puntuacionsMaximes");
        partidesGuanyades = getIntent().getExtras().getInt("partidesGuanyades");
        partidesJugades = getIntent().getExtras().getInt("partidesJugades");

        // Mostra les puntuacions en els TextView del Layout
        actualitzarPuntuacions();

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

    // S'implementa el menú personalitzat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game_menu, menu);
        return true;
    }

    // Es controla quins botons del menú s'estan clicant
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finalitzarIntent();
                return true;

            case R.id.reiniciar:
                reiniciarPuntuacions();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    // Escriu les puntuacions en els TextView del layout
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void actualitzarPuntuacions() {

        TextView textView = (TextView) findViewById(R.id.txtPuntuacioEncertarSimbol);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_SIMBOL]);

        textView = (TextView) findViewById(R.id.txtPuntuacioEncertarNom);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_NOM]);

        textView = (TextView) findViewById(R.id.txtPuntuacioEncertarEstat);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_ESTAT]);

        textView = (TextView) findViewById(R.id.txtPuntuacioEncertarNumero);
        textView.setText("Puntuació màxima: " + puntuacionsMaximes[GAME_ENCERTAR_NUMERO]);

        textView = (TextView) findViewById(R.id.txtPartidesJugades);
        textView.setText("Jugades: " + partidesJugades);

        textView = (TextView) findViewById(R.id.txtPartidesGuanyades);
        textView.setText("Guanyades: " + partidesGuanyades);

        // A la barra de progrés se li configura el valor Max i el valor Progres. La pròpia barra farà el càlcul i mostrarà l'avenç
        ProgressBar graficaProgres = (ProgressBar) findViewById(R.id.graficaProgres);
        graficaProgres.setMax(partidesJugades);
        graficaProgres.setProgress(partidesGuanyades, true);

    }

    // Es reinicien les puntuacions, totes les variables tornen al valor 0
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void reiniciarPuntuacions() {

        for (int index = 0; index < puntuacionsMaximes.length; index++) {
            puntuacionsMaximes[index] = 0;
        }

        partidesJugades = 0;
        partidesGuanyades = 0;

        actualitzarPuntuacions();
    }

    // Inicia el joc corresponent segons quina modalitat s'ha escollit (ho decideix el botó que s'ha clicat)
    private void iniciarJoc(int modalitat) {

        Intent intent;

        switch (modalitat) {

            case GAME_ENCERTAR_SIMBOL:
                intent = new Intent(getApplicationContext(), ActivityGameEncertarSimbol.class);
                break;

            case GAME_ENCERTAR_NOM:
                intent = new Intent(getApplicationContext(), ActivityGameEncertarNom.class);
                break;

            case GAME_ENCERTAR_ESTAT:
                intent = new Intent(getApplicationContext(), ActivityGameEncertarEstat.class);
                break;

            case GAME_ENCERTAR_NUMERO:
                intent = new Intent(getApplicationContext(), ActivityGameEncertarNumero.class);
                break;

            default:
                return;

        }

        intent.putExtra("puntuacio", puntuacionsMaximes[modalitat]);
        startActivityForResult(intent, modalitat);

    }

    // Mètode que s'encarrega de finalitzar l'activity, retornant les puntuacions
    private void finalitzarIntent() {

        // Es crea un bundle amb les puntuacions màximes que s'han obtingut
        Bundle puntuacions = new Bundle();
        puntuacions.putIntArray("puntuacionsMaximes", puntuacionsMaximes);
        puntuacions.putInt("partidesGuanyades", partidesGuanyades);
        puntuacions.putInt("partidesJugades", partidesJugades);

        // Es crea un intent i les puntuacions màximes
        Intent intent = new Intent();
        intent.putExtras(puntuacions);

        // Es finalitza l'activity retornant la puntuació
        setResult(RESULT_OK, intent);
        finish();

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

    // Recull les puntuacions que envien els intents de les modalitats del jod
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int puntuacioRecuperada = data.getExtras().getInt("puntuacio");

        if (resultCode == RESULT_OK) {

            /* Com que en la crida a l'intent se li assigna el mateix numero de requestCode
            *  que la posició que té la seva puntuació màxima en l'array, podem fer aquesta comparació d'una manera
            *  molt més simple */
            if (puntuacioRecuperada > puntuacionsMaximes[requestCode]) {
                puntuacionsMaximes[requestCode] = puntuacioRecuperada;
            }

            // Es controlen quantes partides s'han jugat i guanyat per poder fer les gràfiques
            partidesGuanyades = data.getExtras().getInt("partidesGuanyades") + partidesGuanyades;
            partidesJugades = data.getExtras().getInt("partidesJugades") + partidesJugades;

        }

        actualitzarPuntuacions();

    }
}