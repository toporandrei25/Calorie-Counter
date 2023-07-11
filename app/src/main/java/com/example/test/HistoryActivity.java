package com.example.test;

import static android.content.ContentValues.TAG;
import static android.view.View.VISIBLE;
import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class HistoryActivity extends AppCompatActivity {
private Button btnLogout;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseFirestore firestore;
    TextView textViewAlim1,textViewAlim2,textViewAlim3,textViewAlim4,textViewAlim5,textViewAlim6,textViewAlim7,textViewAlim8,textViewAlim9,textViewAlim10,textViewAlim11,textViewAlim12,textViewAlim13,textViewAlimCon;
    int alim1, alim2,alim3,alim4,alim5,alim6,alim7,alim8,alim9,alim10,alim11,alim12,alim13;
    String x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13;
    String y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13;
    int i;
    String userId2;
    private LinearLayout label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14;
    private Button btnRmv1,btnRmv2,btnRmv3,btnRmv4,btnRmv5,btnRmv6,btnRmv7,btnRmv8,btnRmv9,btnRmv10,btnRmv11,btnRmv12,btnRmv13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        btnLogout = findViewById(R.id.buttonBack2);
        label1 = findViewById(R.id.layout1);
        label2 = findViewById(R.id.layout2);
        label3 = findViewById(R.id.layout3);
        label4 = findViewById(R.id.layout4);
        label5 = findViewById(R.id.layout5);
        label6 = findViewById(R.id.layout6);
        label7 = findViewById(R.id.layout7);
        label8 = findViewById(R.id.layout8);
        label9 = findViewById(R.id.layout9);
        label10 = findViewById(R.id.layout10);
        label11 = findViewById(R.id.layout11);
        label12 = findViewById(R.id.layout12);
        label13 = findViewById(R.id.layout13);

        textViewAlim1 = findViewById(R.id.textAlim1);
        textViewAlim2 = findViewById(R.id.textAlim2);
        textViewAlim3 = findViewById(R.id.textAlim3);
        textViewAlim4 = findViewById(R.id.textAlim4);
        textViewAlim5 = findViewById(R.id.textAlim5);
        textViewAlim6 = findViewById(R.id.textAlim6);
        textViewAlim7 = findViewById(R.id.textAlim7);
        textViewAlim8 = findViewById(R.id.textAlim8);
        textViewAlim9 = findViewById(R.id.textAlim9);
        textViewAlim10 = findViewById(R.id.textAlim10);
        textViewAlim11 = findViewById(R.id.textAlim11);
        textViewAlim12 = findViewById(R.id.textAlim12);
        textViewAlim13 = findViewById(R.id.textAlim13);
        textViewAlimCon = findViewById(R.id.textAlimconsumate);

        btnRmv1 = findViewById(R.id.buttonRmv1);
        btnRmv2 = findViewById(R.id.buttonRmv2);
        btnRmv3 = findViewById(R.id.buttonRmv3);
        btnRmv4 = findViewById(R.id.buttonRmv4);
        btnRmv5 = findViewById(R.id.buttonRmv5);
        btnRmv6 = findViewById(R.id.buttonRmv6);
        btnRmv7 = findViewById(R.id.buttonRmv7);
        btnRmv8 = findViewById(R.id.buttonRmv8);
        btnRmv9 = findViewById(R.id.buttonRmv9);
        btnRmv10 = findViewById(R.id.buttonRmv10);
        btnRmv11 = findViewById(R.id.buttonRmv11);
        btnRmv12 = findViewById(R.id.buttonRmv12);
        btnRmv13 = findViewById(R.id.buttonRmv13);

        auth = FirebaseAuth.getInstance();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        user = auth.getCurrentUser();

        String email = user.getEmail();
        firestore.collection("Users")
                .whereEqualTo("Email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override

                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                userId2 = document.getId();
                                String auxiliar = document.getString("i");
                                i = Integer.parseInt(auxiliar);
                                textViewAlimCon.setText("Ai consumat "+ i +" alimente");
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


                                if(alim1 > 0)
                                {
                                    label1.setVisibility(View.VISIBLE);
                                    textViewAlim1.setText(" Fulgi de ovaz: 100g \n   x:"+ alim1);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim1--;
                                            x1 = String.valueOf(alim1);
                                            y1 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim1", x1,
                                                            "i",y1);
                                            textViewAlim1.setText(" Fulgi de ovaz: 100g \n   x:"+ alim1);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim1 == 0){label1.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim2 > 0)
                                {
                                    label2.setVisibility(View.VISIBLE);
                                    textViewAlim2.setText(" Măr: ~150g \n   x:"+ alim2);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim2--;
                                            x2 = String.valueOf(alim2);
                                            y2 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim2", x2,
                                                            "i",y2);
                                            textViewAlim2.setText(" Măr: ~150g \n   x:"+ alim2);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim2 == 0){label2.setVisibility(View.GONE);}

                                        }
                                    });
                                }

                                if(alim3 > 0)
                                {
                                    label3.setVisibility(View.VISIBLE);
                                    textViewAlim3.setText(" Banana: ~100g \n   x:"+ alim3);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim3--;
                                            x3 = String.valueOf(alim3);
                                            y3 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim3", x3,
                                                            "i",y3);
                                            textViewAlim3.setText(" Banana: ~100g \n   x:"+ alim3);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim3 == 0){label3.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim4 > 0)
                                {
                                    label4.setVisibility(View.VISIBLE);
                                    textViewAlim4.setText(" Piept de pui: 100g \n   x:"+ alim4);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim4--;
                                            x4 = String.valueOf(alim4);
                                            y4 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim4", x4,
                                                            "i",y4);
                                            textViewAlim4.setText(" Piept de pui: 100g \n   x:"+ alim4);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim4 == 0){label4.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim5 > 0)
                                {
                                    label5.setVisibility(View.VISIBLE);
                                    textViewAlim5.setText(" Cartofi la cuptor: 100g \n   x:"+ alim5);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim5--;
                                            x5 = String.valueOf(alim5);
                                            y5 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim5", x5,
                                                            "i",y5);
                                            textViewAlim5.setText(" Cartofi la cuptor: 100g \n   x:"+ alim5);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim5 == 0){label5.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim6 > 0)
                                {
                                    label6.setVisibility(View.VISIBLE);
                                    textViewAlim6.setText(" Paste: 100g \n   x:"+ alim6);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");

                                    btnRmv6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim6--;
                                            x6 = String.valueOf(alim6);
                                            y6 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim6", x6,
                                                            "i",y6);
                                            textViewAlim6.setText(" Paste: 100g \n   x:"+ alim6);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim6 == 0){label6.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim7 > 0)
                                {
                                    label7.setVisibility(View.VISIBLE);
                                    textViewAlim7.setText(" Masline negre: 100g \n   x:"+ alim7);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim7--;
                                            x7 = String.valueOf(alim7);
                                            y7 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim7", x7,
                                                            "i",y7);
                                            textViewAlim7.setText(" Masline negre: 100g \n   x:"+ alim7);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim7 == 0){label7.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim8 > 0)
                                {
                                    label8.setVisibility(View.VISIBLE);
                                    textViewAlim8.setText(" Peste: 100g \n   x:"+ alim8);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim8--;
                                            x8 = String.valueOf(alim8);
                                            y8 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim8", x8,
                                                            "i",y8);
                                            textViewAlim8.setText(" Peste: 100g \n   x:"+ alim8);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim8 == 0){label8.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim9 > 0)
                                {
                                    label9.setVisibility(View.VISIBLE);
                                    textViewAlim9.setText(" Orez: 100g \n   x:"+ alim9);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv9.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim9--;
                                            x9= String.valueOf(alim9);
                                            y9 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim9", x9,
                                                            "i",y9);
                                            textViewAlim9.setText(" Orez: 100g \n   x:"+ alim9);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim9 == 0){label9.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim10 > 0)
                                {
                                    label10.setVisibility(View.VISIBLE);
                                    textViewAlim10.setText(" Paine alba: 100g \n   x:"+ alim10);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv10.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim10--;
                                            x10 = String.valueOf(alim10);
                                            y10 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim10", x10,
                                                            "i",y10);
                                            textViewAlim10.setText(" Paine alba: 100g \n   x:"+ alim10);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim10 == 0){label10.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim11 > 0)
                                {
                                    label11.setVisibility(View.VISIBLE);
                                    textViewAlim11.setText(" Lapte 3.5%: 100g \n   x:"+ alim11);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv11.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim11--;
                                            x11 = String.valueOf(alim11);
                                            y11 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim11", x11,
                                                            "i",y11);
                                            textViewAlim11.setText(" Lapte 3.5%: 100g \n   x:"+ alim11);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim11 == 0){label11.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim12 > 0)
                                {
                                    label12.setVisibility(View.VISIBLE);
                                    textViewAlim12.setText(" Unt de arahide: 100g \n   x:"+ alim12);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv12.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim12--;
                                            x12 = String.valueOf(alim12);
                                            y12 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim12", x12,
                                                            "i",y12);
                                            textViewAlim12.setText(" Unt de arahide: 100g \n   x:"+ alim12);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim12 == 0){label12.setVisibility(View.GONE);}

                                        }
                                    });
                                }
                                if(alim13 > 0)
                                {
                                    label13.setVisibility(View.VISIBLE);
                                    textViewAlim13.setText(" Brocoli: 100g \n   x:"+ alim13);
                                    textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                    btnRmv13.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            i--; alim13--;
                                            x13 = String.valueOf(alim13);
                                            y13 = String.valueOf(i);
                                            firestore.collection("Users").document(userId2)
                                                    .update("alim13", x13,
                                                            "i",y13);
                                            textViewAlim13.setText(" Brocoli: 100g \n   x:"+ alim13);
                                            textViewAlimCon.setText("Ai consumat "+ i +" alimente");
                                            if(alim13 == 0){label13.setVisibility(View.GONE);}

                                        }
                                    });
                                }


                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });






        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Conected.class);
                startActivity(intent);
            }
        });
    }
}