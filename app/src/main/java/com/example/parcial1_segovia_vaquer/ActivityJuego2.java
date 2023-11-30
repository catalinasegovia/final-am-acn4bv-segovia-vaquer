package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityJuego2 extends AppCompatActivity  {

    int[] idCartas = { R.drawable.carta_2, R.drawable.carta_3, R.drawable.carta_4,
            R.drawable.carta_5, R.drawable.carta_6, R.drawable.carta_7, R.drawable.carta_8,
            R.drawable.carta_9, R.drawable.carta_10, R.drawable.carta_q, R.drawable.carta_j,
            R.drawable.carta_k, R.drawable.carta_a,
    };
    List<Integer> mazo;
    private int puntajeJugador;
    private List<Integer> cartasJugador;

    Button btn_otraCarta;
    Button btn_plantarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        inicializarMazo();
        cartasJugador = new ArrayList<>();
        puntajeJugador = 0;

        btn_otraCarta=findViewById(R.id.btn_otraCarta);
        btn_plantarse=findViewById(R.id.btn_continuar);
        btn_plantarse.setVisibility(View.INVISIBLE);

        btn_otraCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repartirCarta();
                if(cartasJugador.size() > 1){
                    btn_plantarse.setVisibility(View.VISIBLE);
                }
                if(puntajeJugador >= 21) {
                    btn_otraCarta.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn_plantarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximaActivity();
            }
        });

        repartirCarta();
    }
    private void proximaActivity(){
        Intent intent = new Intent(ActivityJuego2.this, ActivityJuego3.class);
        intent.putExtra("puntajeJugador", puntajeJugador);
        intent.putIntegerArrayListExtra("mazo", (ArrayList<Integer>) mazo );
        intent.putExtra("idCartas", (int[]) idCartas );
        //ArrayList<Integer> mazo = getIntent().getIntegerArrayListExtra("mazo");
        startActivity(intent);
    }
    private void inicializarMazo() {
        mazo = new ArrayList<>();
        for (int i = 2; i <= 11; i++) {
            int cantCartas = 4;
            if(i==10)
                cantCartas = 16; //Porque son 16 cartas que valen 10: 10, J, Q, K
            for (int j = 0; j < cantCartas; j++) {
                mazo.add(i);
            }
        }
    }

    public int cartaRandom(){
        Random r= new Random();
        int c = r.nextInt(mazo.size());
        return c;
    }

    private void repartirCarta(){
        //Obtengo el indice de la carta del deck
        int valor = -1;
        int index = -1;
        while(valor == -1){
            index = cartaRandom();
            valor = mazo.get(index);
        }
        actualizarImagenCarta(index);

        //Guardo la carta en la lista de cartas del jugador
        cartasJugador.add(valor);
        //Elimino la carta del mazo para que no vuelva a salir
        mazo.set(index,-1);

        actualizarPuntaje();
    }


    private void actualizarPuntaje(){
        puntajeJugador=0;
        for(int carta : cartasJugador){
            puntajeJugador += carta;
        }
    }

    private void actualizarImagenCarta(int index) {
        //Calculo el indice del array de imagenes
        int cartaIndex = index / 4;
        //Obtengo la imagen de la carta a mostrar
        int idCarta = idCartas[cartaIndex];
        //Actualizo la imagen
        ImageView randomImg = findViewById(R.id.randomImg);
        randomImg.setImageResource(idCarta);
    }
}
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        int pc1 = getIntent().getIntExtra("id", -1);
        int idCarta1= getIntent().getIntExtra("imagen", -1);
        int valorCarta1=getIntent().getIntExtra("valor", -1);

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
                intent2.putExtra("id", pc2);
                intent2.putExtra(" imagen", idCarta2);
                intent2.putExtra("valor ", valorCarta2);

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

*/

