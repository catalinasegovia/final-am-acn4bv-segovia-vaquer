package com.example.parcial1_segovia_vaquer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //private FirebaseAuth mAuth;

    Button btn_comenzar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mAuth = FirebaseAuth.getInstance();

        btn_comenzar = findViewById(R.id.btn_comenzar);
        btn_comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comenzar = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(comenzar);

            }
        });
    }


}


