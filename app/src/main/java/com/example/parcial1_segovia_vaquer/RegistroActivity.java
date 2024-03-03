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
        setContentView(R.layout.activity_login);
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

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null){
                                if(user.isEmailVerified()){
                                String userId = user.getUid();

                                Map<String, Object> usuario = new HashMap<>();
                                usuario.put("name", name);
                                usuario.put("email", email);

                                db.collection("users").add(usuario).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        //Log.d("guardado" + documentReference.getId());

                                    }
                                })
                                        .addOnFailureListener(new OnFailureListener() {
                                             @Override
                                               public void onFailure(@NonNull Exception e) {
                                                              Log.w("error" , e);
                                                                  }
                                                              });

                            //Mensaje de confirmacion
                            Log.d("Registro", "Registro exitoso");
                            Toast.makeText(RegistroActivity.this, "Usuario creado exitosamente",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                            startActivity(intent);
                                }
                            }
                        } else {
                            //Mensaje de error
                            Log.w("Registro", "Error de registro", task.getException());
                            Toast.makeText(RegistroActivity.this, "Error al crear usuario.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    }

