package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityLogin extends AppCompatActivity {
    private Button buttonBack;
    private FirebaseAuth mAuth;
    public TextInputEditText editTextEmail;
    public TextInputEditText editTextPassword;
    public Button buttonLogin;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (TextInputEditText )findViewById(R.id.textEmail);
        editTextPassword =(TextInputEditText ) findViewById(R.id.textPass);
        buttonLogin = findViewById(R.id.btnLog);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);



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