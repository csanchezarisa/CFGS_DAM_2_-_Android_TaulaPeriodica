package com.example.taulaperidica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Taula Periòdica");
        actionBar.setDisplayHomeAsUpEnabled(true);


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