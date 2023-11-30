package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityJuego6 extends AppCompatActivity {
    private int puntajeJugador;
    private int puntajeIA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego6);

        puntajeJugador = getIntent().getIntExtra("puntajeJugador",0);
        puntajeIA = getIntent().getIntExtra("puntajeIA",0);

        TextView tv_jugador=findViewById(R.id.tv_jugador);
        tv_jugador.setText(Integer.toString(puntajeJugador));
        TextView tv_ia=findViewById(R.id.tv_ia);
        tv_ia.setText(Integer.toString(puntajeIA));

    }
}