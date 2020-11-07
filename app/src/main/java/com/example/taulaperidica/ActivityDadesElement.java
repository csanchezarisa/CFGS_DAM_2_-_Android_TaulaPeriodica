package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityDadesElement extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dades_element);

        // Es recuperan les dades enviades per l'activity principal
        Bundle element = getIntent().getExtras();

        // Es preparen els colors necessaris per mostrar correctament l'Activity
        String colorFons = "#ffffff";

        switch (element.getString("tipus")) {
            case "no metàl·lic":
                colorFons = "#a0ffa0";
                break;

            case "gas noble":
                colorFons = "#c0ffff";
                break;

            case "metall alcalí":
                colorFons = "#ff6666";
                break;

            case "metall alcalino-terrós":
                colorFons = "#ffdead";
                break;

            case "metal·loide":
                colorFons = "#cccc99";
                break;

            case "halògen":
                colorFons = "#ffff99";
                break;

            case "actinoide":
                colorFons = "#ff99cc";
                break;

            case "metall de transició":
                colorFons = "#ffc0c0";
                break;

            case "lantanoide":
                colorFons = "#ffbfff";
                break;

            case "metall post-transició":
                colorFons = "#cccccc";
                break;
        }

        int colorSimbol = Color.BLACK;

        switch (element.getString("estatPredeterminat")) {
            case "sòlid":
                colorSimbol = Color.BLACK;
                break;

            case "líquid":
                colorSimbol = Color.BLUE;
                break;

            case "sintètic":
                colorSimbol = Color.RED;
                break;

            case "gas":
                colorSimbol = Color.GREEN;
                break;
        }

        // Es personalitza l'action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Es canvia el títol i es possa en color negre
        actionBar.setTitle(Html.fromHtml("<font color = \"black\"> Element " + element.getString("nom") + " - " + element.getString("simbol") + "</font>"));
        // Es canvia el color de fons
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(colorFons)));
        Button btnCompartir = (Button) findViewById(R.id.btnCompartir);
        btnCompartir.setBackgroundColor(Color.parseColor(colorFons));
        btnCompartir.setBackground(new ColorDrawable(R.drawable.boto_rodo));

        // Es modifiquen les parts del layout
        TextView textPerEditar = (TextView) findViewById(R.id.informacioNomElement);
        textPerEditar.setText(element.getString("nom"));

        textPerEditar = (TextView) findViewById(R.id.informacioSimbolElement);
        textPerEditar.setText(element.getString("simbol"));

        textPerEditar = (TextView) findViewById(R.id.informacioNumeroElement);
        textPerEditar.setText(element.getString("numeroAtomic"));

        textPerEditar = (TextView) findViewById(R.id.informacioSerieElement);
        textPerEditar.setText(element.getString("tipus").substring(0, 1).toUpperCase() + element.getString("tipus").substring(1));

        textPerEditar = (TextView) findViewById(R.id.informacioMassaElement);
        textPerEditar.setText(element.getString("massaAtomica"));

        textPerEditar = (TextView) findViewById(R.id.informacioConfiguracioElement);
        textPerEditar.setText(element.getString("configuracioElectronica"));

        textPerEditar = (TextView) findViewById(R.id.informacioEstatElement);
        textPerEditar.setText(element.getString("estatPredeterminat").substring(0, 1).toUpperCase() + element.getString("estatPredeterminat").substring(1));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}