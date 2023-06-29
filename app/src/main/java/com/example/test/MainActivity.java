package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button buttonREG;
   private Button buttonLOG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonREG = (Button) findViewById(R.id.btnreg);
        buttonREG.setOnClickListener(new View.OnClickListener()
                                  {@Override
                                  public void onClick(View v){
                            openActivity3();}});

        buttonLOG = (Button) findViewById(R.id.btnlogin);
        buttonLOG.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v){
            openActivity2();}});
    }
    public void openActivity2()
    {Intent intent = new Intent(this, ActivityLogin.class);
    startActivity(intent);
    }
    public void openActivity3()
    {Intent intent = new Intent(this, ActivityRegister.class);
        startActivity(intent);
    }

}