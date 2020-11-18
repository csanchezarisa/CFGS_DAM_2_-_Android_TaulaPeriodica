package com.example.taulaperidica.personalitzar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.taulaperidica.R;
import com.example.taulaperidica.elements.ElementsColors;

public class ActivityPersonalitzarColors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalitzar_colors);

        // Personalitza la ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"black\">Personalitzar colors</font>"));

        // Personalitza el layout per mostrar la informació sobre els colors que utilitzen els elements
        personalitzarEditText();
        personalitzarMostraColors();

        Button btnAplicarColors = (Button) findViewById(R.id.btnAplicar);
        btnAplicarColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aplicarColors();
                personalitzarEditText();
                personalitzarMostraColors();
            }
        });

        Button btnAplicarColors2 = (Button) findViewById(R.id.btnAplicar2);
        btnAplicarColors2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aplicarColors();
                personalitzarEditText();
                personalitzarMostraColors();
            }
        });

    }

    // Personalitzar el menú d'opcions
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_personalitzar_colors_menu, menu);
        return true;
    }

    // Controla el clic en els botons del menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finalitzarActivity();
                return true;

            case R.id.restablir:
                mostrarAvisRestablirPersonalitzacio();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    // Escolta quan la tecla per tornar endarrera
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finalitzarActivity();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    // Personalitza els EditText per que mostrin el color configurat actualment
    private void personalitzarEditText() {

        // EditText Colors dels estats
        EditText editText = (EditText) findViewById(R.id.edtColorEstatSolid);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getEstatSolid())));

        editText = (EditText) findViewById(R.id.edtColorEstatLiquid);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getEstatLiquid())));

        editText = (EditText) findViewById(R.id.edtColorEstatSintetic);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getEstatSintetic())));

        editText = (EditText) findViewById(R.id.edtColorEstatGas);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getEstatGas())));

        // EditText Colors dels tipus
        editText = (EditText) findViewById(R.id.edtColorTipusNoMetalic);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusNoMetalic())));

        editText = (EditText) findViewById(R.id.edtColorTipusGasNoble);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusGasNoble())));

        editText = (EditText) findViewById(R.id.edtColorTipusMetallAlcali);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusMetallAlcali())));

        editText = (EditText) findViewById(R.id.edtColorTipusMetallAlcalinoTerros);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusMetallAlcaliTerros())));

        editText = (EditText) findViewById(R.id.edtColorTipusMetalloide);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusMetalloide())));

        editText = (EditText) findViewById(R.id.edtColorTipusHalogen);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusHalogen())));

        editText = (EditText) findViewById(R.id.edtColorTipusActinoide);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusActinoide())));

        editText = (EditText) findViewById(R.id.edtColorTipusMetallTransicio);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusmetallTransicio())));

        editText = (EditText) findViewById(R.id.edtColorTipusLantanoide);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusLantanoide())));

        editText = (EditText) findViewById(R.id.edtColorTipusMetallPostTransicio);
        editText.setText(String.format("#%06X", (0xFFFFFF & ElementsColors.getTipusMetallPostTransició())));
    }

    // Configura els TextView per que el color de fons sigui el color configurat, d'aquesta manera es pot fer una previsualització
    private void personalitzarMostraColors() {

        // Mostres dels colors dels estats
        TextView textViewMostra = (TextView) findViewById(R.id.mostraColorEstatSolid);
        textViewMostra.setBackgroundColor(ElementsColors.getEstatSolid());

        textViewMostra = (TextView) findViewById(R.id.mostraColorEstatLiquid);
        textViewMostra.setBackgroundColor(ElementsColors.getEstatLiquid());

        textViewMostra = (TextView) findViewById(R.id.mostraColorEstatSintetic);
        textViewMostra.setBackgroundColor(ElementsColors.getEstatSintetic());

        textViewMostra = (TextView) findViewById(R.id.mostraColorEstatGas);
        textViewMostra.setBackgroundColor(ElementsColors.getEstatGas());

        // Mostres dels colors dels tipus
        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusNoMetalic);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusNoMetalic());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusGasNoble);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusGasNoble());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusMetallAlcali);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusMetallAlcali());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusMetallAlcalinoTerros);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusMetallAlcaliTerros());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusMetalloide);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusMetalloide());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusHalogen);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusHalogen());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusActinoide);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusActinoide());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusMetallTransicio);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusmetallTransicio());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusLantanoide);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusLantanoide());

        textViewMostra = (TextView) findViewById(R.id.mostraColorTipusMetallPostTransicio);
        textViewMostra.setBackgroundColor(ElementsColors.getTipusMetallPostTransició());

    }

    // Canvia els colors de la clase ElementsColors pels que s'han introduit en els EditText
    private void aplicarColors() {

        // Prova a canviar els colors pels introduits per l'usuari. Si hi ha cap problema en alguna de les conversions, el color que s'aplicarà a l'element serà el Default
        EditText editText;

        // Colors dels estats
        try {

            editText = (EditText) findViewById(R.id.edtColorEstatSolid);
            String color = editText.getText().toString();
            ElementsColors.setEstatSolid(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setEstatSolid(ElementsColors.getEstatDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorEstatLiquid);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setEstatLiquid(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setEstatLiquid(ElementsColors.getEstatDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorEstatSintetic);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setEstatSintetic(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setEstatSintetic(ElementsColors.getEstatDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorEstatGas);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setEstatGas(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setEstatGas(ElementsColors.getEstatDefault());

        }

        // Colors dels tipus
        try {

            editText = (EditText) findViewById(R.id.edtColorTipusNoMetalic);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusNoMetalic(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusNoMetalic(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusGasNoble);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusGasNoble(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusGasNoble(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusMetallAlcali);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusMetallAlcali(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusMetallAlcali(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusMetallAlcalinoTerros);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusMetallAlcaliTerros(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusMetallAlcaliTerros(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusMetalloide);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusMetalloide(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusMetalloide(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusHalogen);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusHalogen(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusHalogen(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusActinoide);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusActinoide(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusActinoide(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusMetallTransicio);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusmetallTransicio(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusmetallTransicio(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusLantanoide);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusLantanoide(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusLantanoide(ElementsColors.getTipusDefault());

        }

        try {

            editText = (EditText) findViewById(R.id.edtColorTipusMetallPostTransicio);
            String color = editText.getText().toString().toUpperCase();
            ElementsColors.setTipusMetallPostTransició(Color.parseColor(color));

        }
        catch (Exception e) {

            ElementsColors.setTipusMetallPostTransició(ElementsColors.getTipusDefault());

        }

    }

    // Finalitza l'activity retornant el codi de finalització correcte
    private void finalitzarActivity() {
        setResult(RESULT_OK);
        finish();
    }

    // Configura els colors dels elements per retornar-los als valors predeterminats
    private void restablirColors() {
        ElementsColors.restablirColors();
        personalitzarEditText();
        personalitzarMostraColors();
    }

    private void mostrarAvisRestablirPersonalitzacio() {

        AlertDialog alerta = new AlertDialog.Builder(this).create();

        alerta.setTitle("RESTABLIR COLORS");
        alerta.setMessage("Es restabliran els colors de l'aplicació.\nEstas segur?");

        alerta.setButton(AlertDialog.BUTTON_POSITIVE, "Acceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Restableix els colors personalitzats
                restablirColors();
            }
        });

        alerta.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No fa res, tanca l'alerta
            }
        });

        alerta.show();

    }
}