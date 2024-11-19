package com.example.exam1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragmento1 extends Fragment {

    public EditText editText;
    private SeekBar seekBar;
    private Button saveButton;

    public Fragmento1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        editText = rootView.findViewById(R.id.editText);
        seekBar = rootView.findViewById(R.id.seekBar);
        saveButton = rootView.findViewById(R.id.saveButton);

        // Inicializamos el SeekBar para cambiar el tamaño de texto
        seekBar.setMax(50); // Máximo tamaño de texto
        seekBar.setProgress(20); // Tamaño inicial de texto
        editText.setTextSize(seekBar.getProgress());

        // Configurar el botón para guardar el texto y el tamaño
        saveButton.setOnClickListener(v -> {
            // Guardar el tamaño del texto
            float textSize = seekBar.getProgress();
            editText.setTextSize(textSize);

            // Ir al fragmento 2 para mostrar el texto
            Fragmento2 fragmento2 = (Fragmento2) getFragmentManager().findFragmentByTag(Fragmento2.class.getName());
            if (fragmento2 != null) {
                fragmento2.setTexto(editText.getText().toString());
            }

            // Mostrar mensaje de guardado
            Toast.makeText(getActivity(), "Texto guardado", Toast.LENGTH_SHORT).show();
        });

        return rootView;
    }
}
