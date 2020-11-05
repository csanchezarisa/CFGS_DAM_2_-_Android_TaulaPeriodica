package com.example.taulaperidica.elements;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taulaperidica.R;

public class AdaptadorElement extends ArrayAdapter<Element> {

    private Context context;

    public AdaptadorElement(Context context, Element[] elements) {
        super(context, R.layout.activity_main_layout_element, elements);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Es prepara l'inflater per personalitzar les files del llistat del layout principal
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View fila = inflater.inflate(R.layout.activity_main_layout_element, null);

        // Es genera l'element
        final Element element = (Element) getItem(position);

        // Modifica primera fila, la del número atòmic
        TextView textPerEditar = (TextView) fila.findViewById(R.id.numAtomic);
        textPerEditar.setText(String.valueOf(element.getNumeroAtomic()));

        // Modifica la segona fila, la del símbol de l'element
        textPerEditar = (TextView) fila.findViewById(R.id.simbol);
        textPerEditar.setText(element.getSimbol());

        // Es canvia el color del símbol segons l'estat predeterminat de l'element
        int colorSimbol = Color.BLACK;

        switch (element.getEstatPredeterminat()) {
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

        textPerEditar.setTextColor(colorSimbol);

        // Modifica la tercela fila, la del pes atòmic
        textPerEditar = (TextView) fila.findViewById(R.id.pesAtomic);
        textPerEditar.setText(element.getMassaAtomica());

        // Modifica la quarta fila, la del nom de l'element
        textPerEditar = (TextView) fila.findViewById(R.id.nomElement);
        textPerEditar.setText(element.getNom());

        // Canviar el color de fons de cada elements segons el seu tipus
        String colorFons = "";

        switch (element.getTipus()) {
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

            default:
                colorFons = "#ffffff";
        }

        fila.setBackgroundColor(Color.parseColor(colorFons.toUpperCase()));

        return fila;
    }
}
