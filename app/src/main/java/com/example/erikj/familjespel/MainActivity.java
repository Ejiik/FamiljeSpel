package com.example.erikj.familjespel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPimPamPet;
    private Button btnMedAndraOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPimPamPet = (Button) findViewById(R.id.btnPimPamPet);
        btnMedAndraOrd = (Button) findViewById(R.id.btnMedAndraOrd);
        initListeners();

    }

    private void initListeners(){
        btnPimPamPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PimPamPet.class);
                startActivity(intent);
            }
        });
        btnMedAndraOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MedAndraOrd.class);
                startActivity(intent);
            }
        });
    }

}
