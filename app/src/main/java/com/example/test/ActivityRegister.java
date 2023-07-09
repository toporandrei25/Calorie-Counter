package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ActivityRegister extends AppCompatActivity {
    private Button buttonBack;
    private FirebaseAuth mAuth;
    public TextInputEditText editTextEmail;
    public TextInputEditText editTextPassword;
    public TextInputEditText editTextGreutate;
    public TextInputEditText editTextInaltime;
    public Button buttonRegister;
    private ProgressBar progressBar;

    FirebaseFirestore firestore;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), Conected.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonBack = (Button) findViewById(R.id.butbck);
        editTextEmail = (TextInputEditText )findViewById(R.id.textEmail);
       editTextPassword =(TextInputEditText ) findViewById(R.id.textPass);
       editTextGreutate = (TextInputEditText) findViewById(R.id.textGreutate);
       editTextInaltime = (TextInputEditText) findViewById(R.id.textInaltime);
        buttonRegister = findViewById(R.id.btnsend);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        firestore = FirebaseFirestore.getInstance();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                String inaltime,greutate;
                progressBar.setVisibility(view.VISIBLE);
                email =String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                greutate = String.valueOf(editTextGreutate.getText());
                inaltime = String.valueOf(editTextInaltime.getText());

                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    Toast.makeText(ActivityRegister.this,"Enter Email & Password",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(view.GONE);
               return;
                }


                if(TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                    Toast.makeText(ActivityRegister.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(view.GONE);
               return;
                }
                if(TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)){
                    Toast.makeText(ActivityRegister.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(view.GONE);
                return;



                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(view.GONE);


                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(ActivityRegister.this, "Acount created.",
                                            Toast.LENGTH_SHORT).show();
                                    int i = 0;
                                    Map<String,Object> user = new HashMap<>();
                                    user.put("Email", email);
                                    user.put("Password", password);
                                    user.put("Greutate",greutate);
                                    user.put("Inaltime",inaltime);
                                    user.put("i",i);

                                    firestore.collection("Users")
                                            .add(user)
                                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                @Override
                                                public void onSuccess(DocumentReference documentReference) {
                                                    //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                                                    Intent intent = new Intent(getApplicationContext(), ActivitySetAge.class);
                                                    startActivity(intent);
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
                                                }
                                            });

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(ActivityRegister.this, "Register failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                            }
                        });



            }
        });



        buttonBack.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v){
            openActivity4();}});


    }
    public void openActivity4()
    {Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}