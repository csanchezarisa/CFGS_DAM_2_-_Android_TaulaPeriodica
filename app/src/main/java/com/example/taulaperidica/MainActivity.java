package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.taulaperidica.elements.AdaptadorElement;
import com.example.taulaperidica.elements.Element;

import com.example.taulaperidica.elements.LlistatElements;
import com.example.taulaperidica.game.ActivityGame;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Adaptador públic per poder accedir des d'altres classes
    public AdaptadorElement adaptador;

    // Array amb tots els elements definits. Aquest no s'utilitza en producció, només és un origen de dades
    private Element[] elementsOrigenDades = LlistatElements.elements;

    // Guarda la puntuació més alta
    private int[]  puntuacionsMaximes = new int[4];

    // Aquest Array contindrà els elements que s'han de mostrar per pantalla. És el que es troba en producció i s'abasteix amb la informació de l'Array de la part superior.
    public Element[] elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Es personalitza el títol de la actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color = \"black\">Taula Periòdica</font>"));

        // Es preparar l'array de producció amb totes les dades
        elements = new Element[elementsOrigenDades.length];

        for (int index = 0; index < elementsOrigenDades.length; index++) {
            elements[index] = elementsOrigenDades[index];
        }

        // Es prepara l'adaptador personalitzat per mostrar els elements
        adaptador = new AdaptadorElement(this, elements);

        // S'assigna l'adaptador personalitzat a la llista del layout principal
        ListView llista = (ListView) findViewById(R.id.elementList);
        llista.setAdapter(adaptador);

        llista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Es crea una variable del tipus Element amb l'element seleccionat per treballar més cómodament
                Element element = elements[position];

                // Es crea un Bundle per passar les dades a la següent Activity
                Bundle bundleAmbElement = new Bundle();

                // Es carrega el bundle amb totes les dades de l'element
                bundleAmbElement.putString("simbol", element.getSimbol());
                bundleAmbElement.putString("tipus", element.getTipus());
                bundleAmbElement.putString("numeroAtomic", String.valueOf(element.getNumeroAtomic()));
                bundleAmbElement.putString("nom", element.getNom());
                bundleAmbElement.putString("massaAtomica", element.getMassaAtomica());
                bundleAmbElement.putString("configuracioElectronica", element.getConfiguracioElectronica());
                bundleAmbElement.putString("estatPredeterminat", element.getEstatPredeterminat());

                // Es crea un nou Intent per obrir la nova activity
                Intent intent = new Intent(getApplicationContext(), ActivityDadesElement.class);

                // Es carrega l'Intent amb les dades del Bundle
                intent.putExtras(bundleAmbElement);

                // S'inicia la nova Activity
                startActivity(intent);
            }
        });

    }

    // S'implementa el menú personalitzat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    // Listeners dels botons del menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gameButton:
                launchGame();
                return true;

            case R.id.totsButton:
                noFiltrarLlistat();
                return true;

            case R.id.solidsButton:
                filtrarLlistat("sòlid");
                return true;

            case R.id.gasosButton:
                filtrarLlistat("gas");
                return true;

            case R.id.liquidsButton:
                filtrarLlistat("líquid");
                return true;

            case R.id.sinteticsButton:
                filtrarLlistat("sintètic");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // S'encarrega d'abastir l'Array de producció amb totes les dades
    public void noFiltrarLlistat() {
        elements = new Element[elementsOrigenDades.length];

        // S'agafen tots els elements d'origen i es passen a l'Array en producció
        for (int index = 0; index < elementsOrigenDades.length; index++) {
            elements[index] = elementsOrigenDades[index];
        }

        // Es prepara de nou l'adaptador per mantenir els canvis
        adaptador = new AdaptadorElement(this, elements);

        // S'assigna l'adaptador personalitzat a la llista del layout principal
        ListView llista = (ListView) findViewById(R.id.elementList);
        llista.setAdapter(adaptador);

        // Es notifiquen els canvis
        adaptador.notifyDataSetChanged();
    }

    // S'encarrega de canviar els elements que es troben a l'array de producció segons el filtre escollit
    public void filtrarLlistat(String filtre) {
        ArrayList<Element> llistatElementsFiltrats = new ArrayList<Element>();

        // Es busquen tots els elements que són iguals al filtre desitjat i es passen a un ArrayList
        for (Element element : elementsOrigenDades) {
            if (element.getEstatPredeterminat().equals(filtre)) {
                llistatElementsFiltrats.add(element);
            }
        }

        // Es crea de nou l'array d'elements amb la mateixa mida que l'ArrayList
        this.elements = new Element[llistatElementsFiltrats.size()];

        // Es passen els elements de l'ArrayList a l'Array d'elements en producció
        for (int index = 0; index < llistatElementsFiltrats.size(); index++) {
            elements[index] = llistatElementsFiltrats.get(index);
        }

        // S'allibera la memoria que ocupa la llista
        llistatElementsFiltrats.clear();

        // Es prepara de nou l'adaptador per mantenir els canvis
        adaptador = new AdaptadorElement(this, elements);

        // S'assigna l'adaptador personalitzat a la llista del layout principal
        ListView llista = (ListView) findViewById(R.id.elementList);
        llista.setAdapter(adaptador);

        // Es notifiquen els canvis
        this.adaptador.notifyDataSetChanged();
        
    }

    // Mètode que inicia el joc i prepara l'activity per rebre el número màxim de puntuació
    private void launchGame() {

        // Es crea l'intent
        Intent intent = new Intent(getApplicationContext(), ActivityGame.class);

        // Es crea un bundle amb les puntuacions màximes que s'han aconseguit
        Bundle puntuacions = new Bundle();
        puntuacions.putIntArray("puntuacionsMaximes", puntuacionsMaximes);

        // S'inclouen les puntuacions al intent
        intent.putExtras(puntuacions);

        // S'inicia l'activity esperant el resultat de la puntuació màxima
        startActivityForResult(intent, 1);

    }

    // Canvia la puntuació màxima quan es tanca l'activity game
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            puntuacionsMaximes = data.getExtras().getIntArray("puntuacionsMaximes");
        }
    }
}