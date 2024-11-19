package com.example.exam1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar los tres fragmentos en sus respectivos contenedores
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Agregar Fragmento 1 en el contenedor 1
            Fragmento1 fragmento1 = new Fragmento1();
            transaction.replace(R.id.fragment_container_1, fragmento1);

            // Agregar Fragmento 2 en el contenedor 2
            Fragmento2 fragmento2 = new Fragmento2();
            transaction.replace(R.id.fragment_container_2, fragmento2);

            // Agregar Fragmento 3 en el contenedor 3
            Fragmento3 fragmento3 = new Fragmento3();
            transaction.replace(R.id.fragment_container_3, fragmento3);

            // Confirmar la transacción
            transaction.commit();
        }
    }
}
