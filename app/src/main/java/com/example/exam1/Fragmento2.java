package com.example.exam1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragmento2 extends Fragment {

    private TextView textView;

    public Fragmento2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        textView = rootView.findViewById(R.id.textView);

        return rootView;
    }

    // Método para actualizar el texto desde Fragmento1
    public void setTexto(String texto) {
        textView.setText(texto);
    }
}
