package com.example.parcial1_segovia_vaquer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegistroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


    }

    public void registro(View view) {

        EditText emailInput = findViewById(R.id.txt_email);
        EditText passwordInput = findViewById(R.id.txt_password);
        EditText nameInput = findViewById(R.id.txt_name);

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String name = nameInput.getText().toString();


        //mAuth.signInWithEmailAndPassword(email,password) Lo dejo aca por si no funciona create User
        mAuth.createUserWithEmailAndPassword(email,password)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                   if (user != null){

                                String userId = user.getUid();

                                Map<String, Object> usuario = new HashMap<>();
                                usuario.put("name", name);
                                usuario.put("email", email);
                                usuario.put("puntaje", 0);
                                usuario.put("ranking", 0);

                                db.collection("user").document(userId).set(usuario)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                                //Mensaje de confirmacion
                                                Log.d("Registro", "Registro exitoso");
                                                Toast.makeText(RegistroActivity.this, "Usuario creado exitosamente",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                            }

                                })
                                        .addOnFailureListener(new OnFailureListener() {
                                             @Override
                                               public void onFailure(@NonNull Exception e) {
                                                 Log.w("Registro", "Error con base de datos", e);
                                                 Toast.makeText(RegistroActivity.this, "Error",
                                                         Toast.LENGTH_SHORT).show();

                                             }

                                        });
                            }

                        } else {
                            //Mensaje de error
                            Log.w("Registro", "Error de registro", task.getException());
                            Toast.makeText(RegistroActivity.this, "Error con el registro de usuario",
                                    Toast.LENGTH_SHORT).show();
                                        }
                                }


                });


    }

    public void guardar(View view){
        registro(view);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}





/*@Override
                                    public void onSuccess(Void void) {
                                        Log.d("guardado" ," registro guardado ");

                                    }*/




/*@Override
                                    public void onSuccess(Void void) {
                                        Log.d("guardado" ," registro guardado ");

                                    } mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {*/