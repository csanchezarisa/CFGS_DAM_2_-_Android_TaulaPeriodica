package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.taulaperidica.elements.AdaptadorElement;
import com.example.taulaperidica.elements.Element;

public class MainActivity extends AppCompatActivity {

    public AdaptadorElement adaptador;
    public Element[] elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Es personalitza el títol de la actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Taula Periòdica");

        adaptador = new AdaptadorElement(this, elements);


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
                return true;

            case R.id.totsButton:
                return true;

            case R.id.solidsButton:
                return true;

            case R.id.gasosButton:
                return true;

            case R.id.liquidsButton:
                return true;

            case R.id.sinteticsButton:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}