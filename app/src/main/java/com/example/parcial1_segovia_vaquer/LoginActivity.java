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

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        FirebaseUser user = mAuth.getCurrentUser();
            if(user != null){
                String userId = user.getUid();

                db.collection("users").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String id = document.getId();
                                Object data = document.getData();
                                //Log.i("firebase firestore"," id") + id + "d");
                            }
                        }
                    }
                });
     }
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