package com.example.test;

import static android.content.ContentValues.TAG;
import static com.google.firebase.FirebaseApp.getInstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class Conected extends AppCompatActivity {

     FirebaseAuth auth;
    Button button;
    TextView textViewEmail;
    TextView textViewPassword;
    TextView textViewGreutate;
    TextView textViewInaltime;
    FirebaseUser user;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conected);
         String email,password;
         int inaltime,greutate ;
        auth = FirebaseAuth.getInstance();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        button = findViewById(R.id.logout);
        textViewEmail = findViewById(R.id.user_email);//TEXTVIEW ID
        textViewPassword = findViewById(R.id.user_password);
        textViewGreutate = findViewById(R.id.user_greutate);
        textViewInaltime = findViewById(R.id.user_inaltime);

        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        } else {

            textViewEmail.setText(user.getEmail());//SET EMAIL

        }
        email = String.valueOf(textViewEmail.getText());

        firestore.collection("Users")
                .whereEqualTo("Email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override

                    public void onComplete(@NonNull Task<QuerySnapshot> task) {


                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                 String email = document.getString("Email");
                                 String password = document.getString("Password");
                                 String inaltime = document.getString("Inaltime");
                                 String greutate = document.getString("Greutate");
                                 textViewPassword.setText(password);
                                 textViewInaltime.setText(inaltime);
                                 textViewGreutate.setText(greutate);
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                           Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });



        //BUTTON LOG OOUT
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}