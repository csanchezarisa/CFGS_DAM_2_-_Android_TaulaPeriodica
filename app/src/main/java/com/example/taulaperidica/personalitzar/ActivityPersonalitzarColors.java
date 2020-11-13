package com.example.taulaperidica.personalitzar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.taulaperidica.R;
import com.example.taulaperidica.elements.ElementsColors;

public class ActivityPersonalitzarColors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalitzar_colors);

        personalitzarEditText();
        personalitzarMostraColors();

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
                restablirColors();
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
}