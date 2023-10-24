package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class ActivityJuego2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);


        int[] idCartas = { R.drawable.carta_2, R.drawable.carta_3, R.drawable.carta_4, R.drawable.carta_5, R.drawable.carta_6, R.drawable.carta_7, R.drawable.carta_8,
        R.drawable.carta_9, R.drawable.carta_10, R.drawable.carta_q, R.drawable.carta_j, R.drawable.carta_k, R.drawable.carta_a,
        };
        int  [] valorCarta= { 2,3,4,5,6,7,8,9,10,10,10,10,11};

        Random random = new Random();
        int cartaTot = random.nextInt(idCartas.length);
        int cartaRandom = idCartas[cartaTot];
        int valorCartaRandom= valorCarta[cartaTot];


        ImageView randomImg= findViewById(R.id.randomImg);
        randomImg.setImageResource(cartaRandom);





    }
}