package com.example.exam1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragmento3 extends Fragment {

    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private Button saveButton;

    public Fragmento3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment3, container, false);

        redSeekBar = rootView.findViewById(R.id.redSeekBar);
        greenSeekBar = rootView.findViewById(R.id.greenSeekBar);
        blueSeekBar = rootView.findViewById(R.id.blueSeekBar);
        saveButton = rootView.findViewById(R.id.saveButton);

        // Configurar SeekBars
        redSeekBar.setMax(255);
        greenSeekBar.setMax(255);
        blueSeekBar.setMax(255);

        // Configurar el botón de guardar color
        saveButton.setOnClickListener(v -> {
            int red = redSeekBar.getProgress();
            int green = greenSeekBar.getProgress();
            int blue = blueSeekBar.getProgress();

            // Cambiar color de fondo del EditText en Fragmento1
            Fragmento1 fragmento1 = (Fragmento1) getFragmentManager().findFragmentByTag(Fragmento1.class.getName());
            if (fragmento1 != null) {
                fragmento1.editText.setTextColor(android.graphics.Color.rgb(red, green, blue));
            }

            // Mostrar mensaje
            Toast.makeText(getActivity(), "Color guardado", Toast.LENGTH_SHORT).show();
        });

        return rootView;
    }
}
