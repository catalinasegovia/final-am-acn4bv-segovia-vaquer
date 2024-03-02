package com.example.parcial1_segovia_vaquer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        ref= database.getReference();
    }

    public void login(View view) {
        EditText emailInput = findViewById(R.id.txt_email);
        EditText passwordInput = findViewById(R.id.txt_password);

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUsar();
                            if(user != null){
                                String userId = user.GetUid();
                                ref.child("usuario").child(userId).child("email").addListenerForSingleValueEvent(new ValueEventListener(){
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot){
                                        if(dataSnapshot.exists()){
                                            Intent intent = new Intent(getApplicationContext(), Activity2.class);
                                            startActivity(intent);
                                        } else{
                                            Toast.makeText(LoginActivity.THIS, "No existe usuario con este correo", Toast.LENGTH_SHORT).show();
                                        }
                            }

                            @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError){
                                        //errror
                                    }

                            });
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Falló el login",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    public void onLoginButtonClick(View view){
        login(view);
    }

    public void onRegistroButtonClick(View view) {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }


}

//EditText emailImput = findViewById(R.id.txt_email);
//        EditText passwordImput = findViewById(R.id.txt_password);
//
//        String email = emailImput.getText().toString();
//        String password = passwordImput.getText().toString();
//
//        this.
//public void login(String email, String password) {
//        Log.i("firebase", "email: " + email);
//        Log.i("firebase", "password: " + password);
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        //startActivity(intent);