package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityLogin extends AppCompatActivity {
    private Button buttonBack;
    private FirebaseAuth mAuth;
    public TextInputEditText editTextEmail;
    public TextInputEditText editTextPassword;
    public Button buttonLogin;
    private ProgressBar progressBar;
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
        setContentView(R.layout.activity_login);

        editTextEmail = (TextInputEditText )findViewById(R.id.textEmail);
        editTextPassword =(TextInputEditText ) findViewById(R.id.textPass);
        buttonLogin = findViewById(R.id.btnLog);
        mAuth = FirebaseAuth.getInstance();
        progressBar =  findViewById(R.id.progressBar);


    buttonLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email, password;
            progressBar.setVisibility(view.VISIBLE);
            email =String.valueOf(editTextEmail.getText());
            password = String.valueOf(editTextPassword.getText());


            if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                Toast.makeText(ActivityLogin.this,"Enter Email & Password",Toast.LENGTH_SHORT).show();
                return;
            }


            if(TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                Toast.makeText(ActivityLogin.this,"Enter Email",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)){
                Toast.makeText(ActivityLogin.this,"Enter Password",Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Login Successeful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Conected.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(ActivityLogin.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });



        }
    });





        buttonBack = (Button) findViewById(R.id.butbck);
        buttonBack.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v){
            openActivity5();}});

    }
    public void openActivity5()
    {Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}