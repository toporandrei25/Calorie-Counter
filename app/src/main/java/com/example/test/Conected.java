package com.example.test;

import static android.content.ContentValues.TAG;
import static com.google.firebase.FirebaseApp.getInstance;

import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Conected extends AppCompatActivity {

     FirebaseAuth auth;
    Button button;
    TextView textViewAge;
    TextView textViewEmail;
    TextView textViewPassword;
    TextView textViewGreutate;
    TextView textViewInaltime;
    TextView textViewCalorii;
    TextView textViewCarb;
    TextView textViewProt;
    TextView textViewFat;
    FirebaseUser user;
    FirebaseFirestore firestore;

    ProgressBar progressCalorii;
    ProgressBar progressCarbs;
    ProgressBar progressProt;
    ProgressBar progressFat;
    private Button btndetails;
    private Button btnHist;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conected);
         String email,password;
         int inaltime,greutate;
        auth = FirebaseAuth.getInstance();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        button = findViewById(R.id.logout);
        textViewAge = findViewById(R.id.user_age);
        textViewEmail = findViewById(R.id.user_email);//TEXTVIEW ID
        textViewPassword = findViewById(R.id.user_password);
        textViewGreutate = findViewById(R.id.user_greutate);
        textViewInaltime = findViewById(R.id.user_inaltime);
        textViewCalorii = findViewById(R.id.textCalorii);
        textViewCarb = findViewById(R.id.textCarb);
        textViewProt = findViewById(R.id.textProt);
        textViewFat = findViewById(R.id.textFat);
        progressCalorii = findViewById(R.id.progressCalorii);
        progressCarbs = findViewById(R.id.progressCarb);
        progressProt = findViewById(R.id.progressProt);
        progressFat = findViewById(R.id.progressFat);
        btndetails = findViewById(R.id.user_details);
        btnHist = findViewById(R.id.buttonHist);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        } else {

            textViewEmail.setText(user.getEmail());//SET EMAIL

        }
        email = valueOf(textViewEmail.getText());

        firestore.collection("Users")
                .whereEqualTo("Email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override

                    public void onComplete(@NonNull Task<QuerySnapshot> task) {


                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String age = document.getString("Age");
                                 String email = document.getString("Email");
                                 String password = document.getString("Password");
                                 String inaltime = document.getString("Inaltime");
                                 String greutate = document.getString("Greutate");
                                 textViewAge.setText(age);
                                 textViewEmail.setText(email);
                                 textViewPassword.setText(password);
                                 textViewInaltime.setText(inaltime);
                                 textViewGreutate.setText(greutate);

                                 double carb = 0;
                                double prot = 0;
                                double fat = 0;
                                double calorii = 0;
                                double auxfat =0;

                                int inalt = Integer.parseInt(inaltime);
                                int greu = Integer.parseInt(greutate);
                                 int varsta = Integer.parseInt(age);
                                    int calUsed=500;
                                    int fatUsed = 20;
                                    int carbUsed = 83;
                                    int protUsed = 30;
                                 calorii = 66.5 + (13.8*greu) + (6*inalt) - (6*varsta);
                                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                auxfat = (calorii*0.3);
                                fat = auxfat/9;
                                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                prot = greu * 0.9;
                                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                carb = (calorii*0.55)/4;
                                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                                progressCalorii.setMin(0);
                                progressCalorii.setMax((int)calorii);
                                progressCalorii.setProgress(calUsed);

                                progressCarbs.setMin(0);
                                progressCarbs.setMax(((int)carb));
                                progressCarbs.setProgress(carbUsed);

                                progressProt.setMin(0);
                                progressProt.setMax((int)prot);
                                progressProt.setProgress(protUsed);

                                progressFat.setMin(0);
                                progressFat.setMax((int)fat);
                                progressFat.setProgress(fatUsed);

                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                           Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });



        btndetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String chilograme = valueOf(textViewGreutate.getText());
                String inaltime2  = valueOf(textViewInaltime.getText());
                String varsta2 = valueOf(textViewAge.getText());
                DialogData exampleDialog = new DialogData();
                 exampleDialog.setTransferredStringEmail(email);
                 exampleDialog.setTransferredStringGreutate(chilograme);
                exampleDialog.setTransferredStringInaltime(inaltime2);
                exampleDialog.setTransferredStringVarsta(varsta2);
                exampleDialog.show(getSupportFragmentManager(),"email");
            }
        });

              //BUTTON LOG OOUT
              button.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      FirebaseAuth.getInstance().signOut();
                      Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                      startActivity(intent);
                      finish();
                  }
              });


         btnHist.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                 startActivity(intent);

             }
         });





    }
}