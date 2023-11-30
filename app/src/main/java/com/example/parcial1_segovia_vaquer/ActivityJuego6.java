package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class ActivityJuego6 extends AppCompatActivity {
    private int puntajeJugador;
    private int puntajeIA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego6);

        puntajeJugador = getIntent().getIntExtra("puntajeJugador",0);
        puntajeIA = getIntent().getIntExtra("puntajeIA",0);


        resultadoJuego();

        Button buttonFin = findViewById(R.id.buttonFin);
        buttonFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityJuego6.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }



    public void resultadoJuego() {
        ConstraintLayout layout = findViewById(R.id.layout);
        layout.setBackgroundResource(R.drawable.portada);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);

        if (puntajeJugador > puntajeIA) {
            // El jugador gana
            layout.setBackgroundResource(R.drawable.ganar);

            textView1.setText("¡Felicidades!");
            textView2.setText("¡GANASTE!");

        } else if (puntajeIA > puntajeJugador) {
            // La IA gana
            layout.setBackgroundResource(R.drawable.perder);
            textView1.setText("¡Mejor suerte la próxima!");
            textView2.setText("PERDISTE");
        } else {
            // Empate
            layout.setBackgroundResource(R.drawable.empatar);
            textView1.setText("¡Mejor suerte la próxima!");
            textView2.setText("EMPATASTE");
        }
    } }