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
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private FirebaseFirestore db;

    String email ;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();
    }

    public void login(View view) {
        EditText emailInput = findViewById(R.id.txt_email);
        EditText passwordInput = findViewById(R.id.txt_password);

        email = emailInput.getText().toString();
        password = passwordInput.getText().toString();

                db.collection("user").whereEqualTo("email", email).get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            QuerySnapshot query = task.getResult();

                            if(!query.isEmpty()){
                                for(QueryDocumentSnapshot document : query){
                                   email = document.getString("email");

                                }
                                } else {
                                    Toast.makeText(LoginActivity.this, "email no encontrado",Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(LoginActivity.this, "error",Toast.LENGTH_SHORT).show();

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

/* esto arriba de db collection
        FirebaseUser user = mAuth.getCurrentUser();
                if(user != null){
                String userId = user.getUid();


                mAuth.signInWithEmailAndPassword(email,password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                         @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                             if (task.isSuccessful()){
                                     }
                                      }


                                      //name = document.getString("name");
                                    //Object data = document.getData();
                                    //Log.i("firebase firestore"," id") + id + "d");*/