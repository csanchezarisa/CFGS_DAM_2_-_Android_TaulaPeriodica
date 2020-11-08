package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class ActivityDadesElement extends AppCompatActivity {

    public String nomElement;

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

        // Es canvia el color del botó flotant pel de l'element
        FloatingActionButton btnCompartir = (FloatingActionButton) findViewById(R.id.btnCompartir);
        btnCompartir.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorFons)));
        // Listener pel botó flotant per compartir
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Es recupera el nom de l'element i s'emmagatzema en una variable global de l'Activity
        nomElement = element.getString("nom");

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

        // Es crea un click listener pel text que fa un enllaç a internet
        textPerEditar = (TextView) findViewById(R.id.linkInternet);
        textPerEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/" + nomElement));
                startActivity(intent);
                
            }
        });
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