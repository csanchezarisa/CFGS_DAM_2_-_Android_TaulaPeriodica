package com.example.taulaperidica.elements;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        int colorSimbol;

        switch (element.getEstatPredeterminat()) {
            case "sòlid":
                colorSimbol = ElementsColors.getEstatSolid();
                break;

            case "líquid":
                colorSimbol = ElementsColors.getEstatLiquid();
                break;

            case "sintètic":
                colorSimbol = ElementsColors.getEstatSintetic();
                break;

            case "gas":
                colorSimbol = ElementsColors.getEstatGas();
                break;

            default:
                colorSimbol = ElementsColors.getEstatDefault();
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
        int colorFons;

        switch (element.getTipus()) {
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

        fila.setBackgroundColor(colorFons);

        return fila;
    }
}
