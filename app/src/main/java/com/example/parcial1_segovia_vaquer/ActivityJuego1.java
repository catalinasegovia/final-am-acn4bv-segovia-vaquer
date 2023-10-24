package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import android.os.Bundle;

public class ActivityJuego1 extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego1);



    Button btn_tirar= (Button)findViewById(R.id.btn_carta);
   btn_tirar.setOnClickListener( new View.OnClickListener() {

        public void onClick(View view) {
        Intent intent = new Intent ( getApplicationContext(), ActivityJuego2.class);
        startActivity(intent);
    }

    });
}}
