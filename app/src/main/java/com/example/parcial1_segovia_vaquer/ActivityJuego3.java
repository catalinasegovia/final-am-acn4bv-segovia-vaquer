package com.example.parcial1_segovia_vaquer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ActivityJuego3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego3);



        int pc2 = getIntent().getIntExtra("id", -1);
        int idCarta2= getIntent().getIntExtra("imagen", -1);
        int valorCarta2=getIntent().getIntExtra("valor", -1);

        if (pc2 != -1 && idCarta2 != -1 && valorCarta2 != -1){

            ImageView imagenC2= findViewById(R.id.carta2);
            imagenC2.setImageResource(idCarta2);

        }


    Button btn_plantarse= (Button)findViewById(R.id.btn_plantarse);
    btn_plantarse.setOnClickListener( new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent= new Intent(getApplicationContext(), ActivityJuego4.class);
            startActivity(intent);
        }
    });



        Button btn_4= (Button)findViewById(R.id.btn_4);
        btn_4.setOnClickListener( new View.OnClickListener() {

            //tercera carta si el jugador toca el boton de tirar otra carta
            public void onClick(View view) {

                int pc3 = cartaRandom3();
                int idCarta3= idCartasI[pc3];
                int valorCarta3=valorI[pc3];

                if (pc3 != -1 && idCarta3 != -1 && valorCarta3 != -1){

                    ImageView imagenC2= findViewById(R.id.carta2);
                    imagenC2.setImageResource(idCarta3);

                }
            }




        });

}

    int[] idCartasI= getIntent().getIntArrayExtra("id cartas");
    int[] valorI= getIntent().getIntArrayExtra("valor cartas");
    public int cartaRandom3(){
        Random c3= new Random();

        int p3= c3.nextInt(idCartasI.length);
        return p3;
    }



}








