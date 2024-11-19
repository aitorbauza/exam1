package com.example.exam1;

import android.content.Intent;
import android.animation.ArgbEvaluator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View sun; // Vista del sol
    private View sky; // Vista del cielo
    private boolean isAnimating = false; // Estado de la animación
    private boolean isNight = false; // Estado del día/noche

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias de las vistas
        sun = findViewById(R.id.sun);
        sky = findViewById(R.id.sky);
        ImageButton button1 = findViewById(R.id.button1);  //

        // Listener para el botón de luna
        button1.setOnClickListener(v -> {
            // Redirigir a MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        // Listener para manejar clics en el cielo
        sky.setOnClickListener(v -> {
            if (!isAnimating) {
                if (isNight) {
                    resetToInitialState(); // Reiniciar a la posición inicial
                } else {
                    startSunsetAnimation(); // Iniciar transición al atardecer
                }
            }
        });
    }

    // Animación del atardecer con colores específicos
    private void startSunsetAnimation() {
        isAnimating = true; // Marcar que la animación está en progreso

        // Animar el movimiento del sol hacia abajo (4.5 segundos)
        ObjectAnimator sunAnimator = ObjectAnimator.ofFloat(sun, "translationY", 1300f);
        sunAnimator.setDuration(4500); // 4.5 segundos para el descenso del sol

        // Cambiar el color del cielo a gris (1.5 segundos)
        ObjectAnimator skyToGray = ObjectAnimator.ofObject(sky, "backgroundColor",
                new ArgbEvaluator(),
                Color.parseColor("#87CEEB"),  // Azul claro (estado inicial)
                Color.parseColor("#808080")); // Gris
        skyToGray.setDuration(1500); // 1.5 segundos para cambiar a gris

        // Cambiar el color del cielo a naranja (1.5 segundos)
        ObjectAnimator skyToOrange = ObjectAnimator.ofObject(sky, "backgroundColor",
                new ArgbEvaluator(),
                Color.parseColor("#808080"),  // Gris
                Color.parseColor("#FFA500")); // Naranja
        skyToOrange.setStartDelay(1500); // Empieza después de la transición a gris
        skyToOrange.setDuration(1500); // 1.5 segundos para cambiar a naranja

        // Cambiar el color del cielo a azul oscuro (1.5 segundos)
        ObjectAnimator skyToDarkBlue = ObjectAnimator.ofObject(sky, "backgroundColor",
                new ArgbEvaluator(),
                Color.parseColor("#FFA500"),  // Naranja
                Color.parseColor("#000080")); // Azul oscuro
        skyToDarkBlue.setStartDelay(3000); // Empieza después de la transición a naranja
        skyToDarkBlue.setDuration(1500); // 1.5 segundos para cambiar a azul oscuro

        // Configurar las animaciones para que ocurran en secuencia
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(sunAnimator) // Animar el sol descendiendo
                .with(skyToGray) // Azul claro a gris al mismo tiempo que el sol desciende
                .with(skyToOrange) // Gris a naranja con un retraso de 1.5 segundos
                .with(skyToDarkBlue); // Naranja a azul oscuro después de 3 segundos
        animatorSet.start();

        // Listener para actualizar el estado cuando termine la animación
        animatorSet.addListener(new android.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(android.animation.Animator animation) {}

            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                isAnimating = false; // Animación completa
                isNight = true; // Ahora es de noche
            }

            @Override
            public void onAnimationCancel(android.animation.Animator animation) {}

            @Override
            public void onAnimationRepeat(android.animation.Animator animation) {}
        });
    }

    // Método que reinicia el sol y el cielo al estado inicial
    private void resetToInitialState() {
        // Reinicia posición del sol
        sun.setTranslationY(0f);

        // Reinicia el color del cielo
        sky.setBackgroundColor(Color.parseColor("#87CEEB")); // Azul claro (estado inicial)

        // Reinicia los estados
        isAnimating = false;
        isNight = false;
    }
}