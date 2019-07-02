package com.example.erikj.familjespel;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MedAndraOrd extends AppCompatActivity {

    private TextView tvWord;
    private Button btnNewWord;
    private Resources res;
    private ArrayList<String> words;
    private int currentWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_andra_ord);

        tvWord = (TextView) findViewById(R.id.tvWord);
        btnNewWord = (Button) findViewById(R.id.btnNewWord);

        res = getResources();
        fillWordsList();
        tvWord.setText("Klicka på \"NY!\" för att börja!");

        btnNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(words.size() > 0){
                    tvWord.setText(words.get(randInt(words.size())));
                    words.remove(currentWord);
                } else{
                    Toast.makeText(getApplicationContext(),"Ord slut! Ny runda!",Toast.LENGTH_LONG).show();
                    fillWordsList();
                }
            }
        });
    }

    private void fillWordsList(){
        words = new ArrayList<String>(Arrays.asList(res.getStringArray(R.array.MedAndraOrd_words_array)));
    }

    private int randInt(int bound){
        Random rnd = new Random();
        currentWord = rnd.nextInt(bound);
        return currentWord;
    }
}
