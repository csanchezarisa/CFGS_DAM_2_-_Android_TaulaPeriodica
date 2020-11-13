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

import com.example.taulaperidica.elements.ElementsColors;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class ActivityDadesElement extends AppCompatActivity {

    private Bundle element;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dades_element);

        // Es recuperan les dades enviades per l'activity principal
        element = getIntent().getExtras();

        // Es preparen els colors necessaris per mostrar correctament l'Activity
        int colorFons;

        switch (element.getString("tipus")) {
            case "no metàl·lic":
                colorFons = ElementsColors.getTipusNoMetalic();
                break;

            case "gas noble":
                colorFons = ElementsColors.getTipusGasNoble();
                break;

            case "metall alcalí":
                colorFons = ElementsColors.getTipusMetallAlcali();
                break;

            case "metall alcalino-terrós":
                colorFons = ElementsColors.getTipusMetallAlcaliTerros();
                break;

            case "metal·loide":
                colorFons = ElementsColors.getTipusMetalloide();;
                break;

            case "halògen":
                colorFons = ElementsColors.getTipusHalogen();
                break;

            case "actinoide":
                colorFons = ElementsColors.getTipusActinoide();
                break;

            case "metall de transició":
                colorFons = ElementsColors.getTipusmetallTransicio();
                break;

            case "lantanoide":
                colorFons = ElementsColors.getTipusLactinoide();
                break;

            case "metall post-transició":
                colorFons = ElementsColors.getTipusMetallPostTransició();
                break;

            default:
                colorFons = ElementsColors.getTipusDefault();
        }

        // Es personalitza l'action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Es canvia el títol i es possa en color negre
        actionBar.setTitle(Html.fromHtml("<font color = \"black\"> Element " + element.getString("nom") + " - " + element.getString("simbol") + "</font>"));
        // Es canvia el color de fons
        actionBar.setBackgroundDrawable(new ColorDrawable(colorFons));

        // Es canvia el color del botó flotant pel de l'element
        FloatingActionButton btnCompartir = (FloatingActionButton) findViewById(R.id.btnCompartir);
        btnCompartir.setBackgroundTintList(ColorStateList.valueOf(colorFons));
        // Listener pel botó flotant per compartir
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirInformacio();
            }
        });

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
                obrirLinkWikipedia();
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

    // Comparteix la informació de l'element mitjançant aplicacions de missatgeria
    private void compartirInformacio() {

        // Es crea un intent
        Intent intent = new Intent();

        // Es prepara el missatge amb les dades de l'element que es vol enviar
        String missatge = "Mitjançant la fantàstica aplicació \"Taula Periòdica\" he trobat la informació de l'element " + element.getString("nom") + "\n" +
                "Nom:\t\t\t" + element.getString("nom") + "\n" +
                "Simbol:\t\t\t" + element.getString("simbol") + "\n" +
                "Número:\t\t\t" + element.getString("numeroAtomic") + "\n" +
                "Sèrie Química:\t" + element.getString("tipus").substring(0, 1).toUpperCase() + element.getString("tipus").substring(1) + "\n" +
                "Massa:\t\t\t" + element.getString("massaAtomica") + "\n" +
                "Configuració:\t" + element.getString("configuracioElectronica") + "\n" +
                "Estat:\t\t\t" + element.getString("estatPredeterminat").substring(0, 1).toUpperCase() + element.getString("estatPredeterminat").substring(1);

        // Es configura l'intent per obrir una aplicació de missatgeria y es carrega amb les dades del missatge
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, missatge);
        intent.setType("text/plain");

        // S'inicia l'activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    // Obre l'enllaç a Wikipedia de l'element seleccionat
    private void obrirLinkWikipedia() {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ca.wikipedia.org/wiki/" + element.getString("nom")));
        startActivity(intent);

    }
}