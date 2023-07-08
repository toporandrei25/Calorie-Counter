package com.example.test;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;


public class ActivitySetAge extends AppCompatActivity {


    private Button buttonNext;
    public TextInputEditText editTextAge;
    private TextView textViewEmail;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseFirestore firestore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_age);

        buttonNext = (Button) findViewById(R.id.btnNext);
        editTextAge = (TextInputEditText)findViewById(R.id.textAge);
        textViewEmail = (TextView) findViewById(R.id.user_email);
        auth = FirebaseAuth.getInstance();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        } else {

            textViewEmail.setText(user.getEmail());//SET EMAIL

        }


        String email;


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

                              Log.d(TAG, document.getId() + " => " + document.getData());
                             String userId = document.getId();
                             //textViewEmail.setText(userId);
                                buttonNext.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String age;
                                        age = String.valueOf(editTextAge.getText());



                                        if(TextUtils.isEmpty(age)){
                                            Toast.makeText(ActivitySetAge.this,"Enter Your Age!",Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        else{     Map<String,Object> user = new HashMap<>();
                                            user.put("Age", age);


                                            firestore.collection("Users").document(userId)
                                                    .set(user, SetOptions.merge());
                                            Intent intent = new Intent(getApplicationContext(), Conected.class);
                                            startActivity(intent);

                                        }
                                    }
                                });

                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });




    }


}