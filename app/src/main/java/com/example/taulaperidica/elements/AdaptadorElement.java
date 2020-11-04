package com.example.taulaperidica.elements;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.taulaperidica.R;

public class AdaptadorElement extends ArrayAdapter<Element> {

    private Context context;

    public AdaptadorElement(Context context, Element[] elements) {
        super(context, R.layout.activity_main_layout_element);
        this.context = context;
    }

}
