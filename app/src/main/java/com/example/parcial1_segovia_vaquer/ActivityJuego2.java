package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ActivityJuego2 extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        int pc1 = getIntent().getIntExtra("", -1);
        int idCarta1= getIntent().getIntExtra("", -1);
        int valorCarta1=getIntent().getIntExtra("", -1);

        if (pc1 != -1 && idCarta1 != -1 && valorCarta1 != -1){

            ImageView imagenC1= findViewById(R.id.randomImg);
            imagenC1.setImageResource(idCarta1);

        }

        Button btn_3= (Button)findViewById(R.id.btn_3);

        btn_3.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {


                int pc2 = cartaRandom2();
                int idCarta2= idCartasI[pc2];
                int valorCarta2=valorI[pc2];

                Intent intent2 = new Intent ( getApplicationContext(), ActivityJuego3.class);
                intent2.putExtra("posicion", pc2);
                intent2.putExtra("id imagen", idCarta2);
                intent2.putExtra("valor carta", valorCarta2);

                startActivity(intent2);

            }
        });




    }

    int[] idCartasI= getIntent().getIntArrayExtra("id cartas");
    int[] valorI= getIntent().getIntArrayExtra("valor cartas");

    public int cartaRandom2(){
        Random c2= new Random();

        int pc2= c2.nextInt(idCartasI.length);

        Intent intent2 = new Intent ( getApplicationContext(), ActivityJuego3.class);
        startActivity(intent2);

        return pc2;
    }



    }



