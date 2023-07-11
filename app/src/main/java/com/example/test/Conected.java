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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

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

    private Button btnAdd1,btnAdd2,btnAdd3,btnAdd4,btnAdd5,btnAdd6,btnAdd7,btnAdd8,btnAdd9,btnAdd10,btnAdd11,btnAdd12,btnAdd13;
    int calUsed=0;
    int fatUsed = 0;
    int carbUsed = 0;
    int protUsed = 0;
    double carb = 0;
    double prot = 0;
    double fat = 0;
    double calorii = 0;
    double auxfat =0;
    int i;
    int alim1, alim2,alim3,alim4,alim5,alim6,alim7,alim8,alim9,alim10,alim11,alim12,alim13;
    String x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13;
    String y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13;
    String userId1;
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
        btnAdd1 = findViewById(R.id.buttonAdd1);
        btnAdd2 = findViewById(R.id.buttonAdd2);
        btnAdd3 = findViewById(R.id.buttonAdd3);
        btnAdd4 = findViewById(R.id.buttonAdd4);
        btnAdd5 = findViewById(R.id.buttonAdd5);
        btnAdd6 = findViewById(R.id.buttonAdd6);
        btnAdd7 = findViewById(R.id.buttonAdd7);
        btnAdd8 = findViewById(R.id.buttonAdd8);
        btnAdd9 = findViewById(R.id.buttonAdd9);
        btnAdd10 = findViewById(R.id.buttonAdd10);
        btnAdd11 = findViewById(R.id.buttonAdd11);
        btnAdd12 = findViewById(R.id.buttonAdd12);
        btnAdd13 = findViewById(R.id.buttonAdd13);
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
                                          userId1 = document.getId();
                                 String auxiliar = document.getString("i");
                                 textViewAge.setText(age);
                                 textViewEmail.setText(email);
                                 textViewPassword.setText(password);
                                 textViewInaltime.setText(inaltime);
                                 textViewGreutate.setText(greutate);
                                 x1 = document.getString("alim1");
                                 x2 = document.getString("alim2");
                                 x3 = document.getString("alim3");
                                x4 = document.getString("alim4");
                                x5 = document.getString("alim5");
                                x6 = document.getString("alim6");
                                x7 = document.getString("alim7");
                                x8 = document.getString("alim8");
                                x9 = document.getString("alim9");
                                x10 = document.getString("alim10");
                                x11 = document.getString("alim11");
                                x12 = document.getString("alim12");
                                x13 = document.getString("alim13");

                                alim1 = Integer.parseInt(x1);
                                alim2 = Integer.parseInt(x2);
                                alim3 = Integer.parseInt(x3);
                                alim4 = Integer.parseInt(x4);
                                alim5 = Integer.parseInt(x5);
                                alim6 = Integer.parseInt(x6);
                                alim7 = Integer.parseInt(x7);
                                alim8 = Integer.parseInt(x8);
                                alim9 = Integer.parseInt(x9);
                                alim10 = Integer.parseInt(x10);
                                alim11 = Integer.parseInt(x11);
                                alim12 = Integer.parseInt(x12);
                                alim13 = Integer.parseInt(x13);

                                    i = Integer.parseInt(auxiliar);
                                int inalt = Integer.parseInt(inaltime);
                                int greu = Integer.parseInt(greutate);
                                 int varsta = Integer.parseInt(age);

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

                                if(alim1 > 0)
                                {   calUsed = calUsed + 240 * alim1;
                                    carbUsed = carbUsed + 54 * alim1;
                                    protUsed = protUsed + 17 * alim1;
                                    fatUsed = fatUsed + 6 * alim1;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");

                                }
                                if(alim2 > 0) {
                                    calUsed = calUsed + 95 * alim2;
                                    carbUsed = carbUsed + 25 * alim2;
                                    protUsed = protUsed + 5 * alim2;
                                    fatUsed = fatUsed + 1 * alim2;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim3 > 0){
                                    calUsed = calUsed + 105 * alim3;
                                    carbUsed = carbUsed + 27 * alim3;
                                    protUsed = protUsed + 3 * alim3;
                                    fatUsed = fatUsed + 1 * alim3;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim4 > 0){
                                    calUsed = calUsed + 110 * alim4;
                                    carbUsed = carbUsed + 1 * alim4;
                                    protUsed = protUsed + 22 * alim4;
                                    fatUsed = fatUsed + 1 * alim4;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim5 > 0){
                                    calUsed = calUsed + 130 * alim5;
                                    carbUsed = carbUsed + 34 * alim5;
                                    protUsed = protUsed + 5 * alim5;
                                    fatUsed = fatUsed + 1 * alim5;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                                }

                                if(alim6 > 0){
                                    calUsed = calUsed + 130 * alim6;
                                    carbUsed = carbUsed + 25 * alim6;
                                    protUsed = protUsed + 5 * alim6;
                                    fatUsed = fatUsed + 1 * alim6;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim7 > 0){
                                    calUsed = calUsed + 130 * alim7;
                                    carbUsed = carbUsed + 7 * alim7;
                                    protUsed = protUsed + 2 * alim7;
                                    fatUsed = fatUsed + 20 * alim7;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim8 > 0){
                                    calUsed = calUsed + 170 * alim8;
                                    carbUsed = carbUsed + 1 * alim8;
                                    protUsed = protUsed + 20 * alim8;
                                    fatUsed = fatUsed + 10 * alim8;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim9 > 0){
                                    calUsed = calUsed + 135 * alim9;
                                    carbUsed = carbUsed + 28 * alim9;
                                    protUsed = protUsed + 2 * alim9;
                                    fatUsed = fatUsed + 1 * alim9;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim10 > 0){
                                    calUsed = calUsed + 250 * alim10;
                                    carbUsed = carbUsed + 60 * alim10;
                                    protUsed = protUsed + 10 * alim10;
                                    fatUsed = fatUsed + 4 * alim10;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim11 > 0){
                                    calUsed = calUsed + 65 * alim11;
                                    carbUsed = carbUsed + 5 * alim11;
                                    protUsed = protUsed + 3 * alim11;
                                    fatUsed = fatUsed + 3 * alim11;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim12 > 0){
                                    calUsed = calUsed + 600 * alim12;
                                    carbUsed = carbUsed + 25 * alim12;
                                    protUsed = protUsed + 30 * alim12;
                                    fatUsed = fatUsed + 50 * alim12;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}

                                if(alim13 > 0){
                                    calUsed = calUsed + 35 * alim13;
                                    carbUsed = carbUsed + 8 * alim13;
                                    protUsed = protUsed + 3 * alim13;
                                    fatUsed = fatUsed + 1 * alim13;

                                    progressCalorii.setProgress(calUsed);
                                    progressCarbs.setProgress(carbUsed);
                                    progressProt.setProgress(protUsed);
                                    progressFat.setProgress(fatUsed);

                                    textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                                    textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                                    textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                                    textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");}




                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                           Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });


        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 240;
                carbUsed = carbUsed + 54;
                protUsed = protUsed + 17;
                fatUsed = fatUsed + 6;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim1++;  i++;
                x1 = String.valueOf(alim1);
                y1 = String.valueOf(i);

                 firestore.collection("Users").document(userId1)
                         .update("alim1", x1,
                                 "i",y1);



            }
        });


        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 95;
                carbUsed = carbUsed + 25;
                protUsed = protUsed + 5;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim2++; i++;
                x2 = String.valueOf(alim2);
                y2 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim2", x2,
                                "i",y2);
            }
        });

        btnAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 105;
                carbUsed = carbUsed + 27;
                protUsed = protUsed + 3;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim3++; i++;
                x3 = String.valueOf(alim3);
                y3 = String.valueOf(i);
                firestore.collection("Users").document(userId1)
                        .update("alim3", x3,
                                "i",y3);
            }
        });

        btnAdd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 110;
                carbUsed = carbUsed + 1;
                protUsed = protUsed + 22;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim4++;  i++;
                x4 = String.valueOf(alim4);
                y4 = String.valueOf(i);

                firestore.collection("Users").document(userId1)
                        .update("alim4", x4,
                                "i",y4);
            }
        });


        btnAdd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 130;
                carbUsed = carbUsed + 34;
                protUsed = protUsed + 5;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim5++; i++;
                x5 = String.valueOf(alim5);
                y5 = String.valueOf(i);

                firestore.collection("Users").document(userId1)
                        .update("alim5", x5,
                                "i",y5);
            }
        });

        btnAdd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 130;
                carbUsed = carbUsed + 25;
                protUsed = protUsed + 5;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim6++; i++;
                x6 = String.valueOf(alim6);
                y6 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim6", x6,
                                "i",y6);
            }
        });

        btnAdd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 130;
                carbUsed = carbUsed + 7;
                protUsed = protUsed + 2;
                fatUsed = fatUsed + 20;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim7++; i++;
                x7 = String.valueOf(alim7);
                y7 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim7", x7,
                                "i",y7);
            }
        });

        btnAdd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 170;
                carbUsed = carbUsed + 1;
                protUsed = protUsed + 20;
                fatUsed = fatUsed + 10;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim8++;  i++;
                x8 = String.valueOf(alim8);
                y8 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim8", x8,
                                "i",y8);
            }
        });

        btnAdd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 135;
                carbUsed = carbUsed + 28;
                protUsed = protUsed + 2;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim9++; i++;
                x9 = String.valueOf(alim9);
                y9 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim9", x9,
                                "i",y8);
            }
        });

        btnAdd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 250;
                carbUsed = carbUsed + 60;
                protUsed = protUsed + 10;
                fatUsed = fatUsed + 4;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim10++; i++;
                x10 = String.valueOf(alim10);
                y10 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim10", x10,
                                "i",y10);
            }
        });


        btnAdd11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 65;
                carbUsed = carbUsed + 5;
                protUsed = protUsed + 3;
                fatUsed = fatUsed + 3;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim11++; i++;
                x11 = String.valueOf(alim11);
                y11 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim11", x11,
                                "i",y11);
            }
        });


        btnAdd12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 600;
                carbUsed = carbUsed + 25;
                protUsed = protUsed + 30;
                fatUsed = fatUsed + 50;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim12++; i++;
                x12 = String.valueOf(alim12);
                y12 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim12", x12,
                                "i",y12);
            }
        });
        btnAdd13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calUsed = calUsed + 35;
                carbUsed = carbUsed + 8;
                protUsed = protUsed + 3;
                fatUsed = fatUsed + 1;

                progressCalorii.setProgress(calUsed);
                progressCarbs.setProgress(carbUsed);
                progressProt.setProgress(protUsed);
                progressFat.setProgress(fatUsed);

                textViewCalorii.setText(valueOf(calUsed)+"/"+valueOf((int)calorii));
                textViewFat.setText(valueOf(fatUsed)+"/"+valueOf((int)fat)+"g");
                textViewProt.setText(valueOf(protUsed)+"/"+valueOf((int)prot)+"g");
                textViewCarb.setText(valueOf(carbUsed)+"/"+valueOf((int)carb)+"g");
                alim13++; i++;
                x13 = String.valueOf(alim13);
                y13 = String.valueOf(i);


                firestore.collection("Users").document(userId1)
                        .update("alim13", x13,
                                "i",y13);
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