package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import android.os.Bundle;

import java.util.Random;

public class ActivityJuego1 extends AppCompatActivity  {

    int[] idCartas = { R.drawable.carta_2, R.drawable.carta_3, R.drawable.carta_4, R.drawable.carta_5, R.drawable.carta_6, R.drawable.carta_7, R.drawable.carta_8,
            R.drawable.carta_9, R.drawable.carta_10, R.drawable.carta_q, R.drawable.carta_j, R.drawable.carta_k, R.drawable.carta_a,
    };
    int  [] valor= { 2,3,4,5,6,7,8,9,10,10,10,10,11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego1);

        //intent para utilizar los arrays en activity 2 para luego crear las cartas
        Intent arrayI= new Intent(ActivityJuego1.this, ActivityJuego2.class);
        arrayI.putExtra("array id cartas" , idCartas);
        arrayI.putExtra("array valor cartas", valor);
        startActivity(arrayI);


        // intent para utilizar los arrays en activity 3 para luego crear las cartas
        Intent array2= new Intent(ActivityJuego1.this, ActivityJuego3.class);
        array2.putExtra("array id cartas" , idCartas);
        array2.putExtra("array valor cartas", valor);
        startActivity(array2);




    Button btn_tirar= (Button)findViewById(R.id.btn_carta);
   btn_tirar.setOnClickListener( new View.OnClickListener() {

        public void onClick(View view) {

            int pc1 = cartaRandom();

            int idCarta1= idCartas[pc1];
            int valorCarta1=valor[pc1];

            Intent intent1 = new Intent ( ActivityJuego1.this, ActivityJuego2.class);
            intent1.putExtra("id", pc1);
            intent1.putExtra("imagen", idCarta1);
            intent1.putExtra("valor ", valorCarta1);

            startActivity(intent1);


    }

    });


}       public int cartaRandom(){
        Random c1= new Random();

        int pc1= c1.nextInt(idCartas.length);

        Intent intent1 = new Intent ( getApplicationContext(), ActivityJuego2.class);
        startActivity(intent1);

        return pc1;
    }

}
