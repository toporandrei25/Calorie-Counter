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
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ActivityRegister extends AppCompatActivity {
    private Button buttonBack;
    private FirebaseAuth mAuth;
    public TextInputEditText editTextEmail;
    public TextInputEditText editTextPassword;
    public Button buttonRegister;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonBack = (Button) findViewById(R.id.butbck);
        editTextEmail = (TextInputEditText )findViewById(R.id.textEmail);
       editTextPassword =(TextInputEditText ) findViewById(R.id.textPass);
        buttonRegister = findViewById(R.id.btnsend);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                progressBar.setVisibility(view.VISIBLE);
                email =String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());


                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    Toast.makeText(ActivityRegister.this,"Enter Email & Password",Toast.LENGTH_SHORT).show();
                }


                if(TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                    Toast.makeText(ActivityRegister.this,"Enter Email",Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)){
                    Toast.makeText(ActivityRegister.this,"Enter Password",Toast.LENGTH_SHORT).show();
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

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(ActivityRegister.this, "Authentication failed.",
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