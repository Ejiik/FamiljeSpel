package com.example.erikj.familjespel;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PimPamPet extends AppCompatActivity {

    private TextView tvPhrase;
    private TextView tvLetter;
    private Button btnNewPhrase;
    private Button btnNewLetter;
    private Button btnNew;
    private ArrayList<String> words;
    private Resources res;
    private int currentWord;
    private String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V/W","Y"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pim_pam_pet);

        tvPhrase = (TextView) findViewById(R.id.tvPhrase);
        tvLetter = (TextView) findViewById(R.id.tvLetter);
        btnNewPhrase = (Button) findViewById(R.id.btnNewPhrase);
        btnNewLetter = (Button) findViewById(R.id.btnNewLetter);
        btnNew = (Button) findViewById(R.id.btnNew);

        res = getResources();

        fillWordsList();

        tvPhrase.setText(words.get(randInt(words.size())));
        tvLetter.setText(randChar());
        initListeners();

    }

    private void fillWordsList(){
        words = new ArrayList<String>(Arrays.asList(res.getStringArray(R.array.PimPamPet_words_array)));
    }

    private int randInt(int bound){
        Random rand = new Random();
        currentWord = rand.nextInt(bound);
        return currentWord;
    }

    private String randChar(){
        Random rnd = new Random();
        return alphabet[rnd.nextInt(alphabet.length)];
    }

    private void initListeners(){
        btnNewPhrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(words.size() > 0){
                    tvPhrase.setText(words.get(randInt(words.size())));
                    words.remove(currentWord);
                } else{
                    Toast.makeText(getApplicationContext(), "Ord slut! Ny runda!", Toast.LENGTH_LONG).show();
                    fillWordsList();
                }
                //Log.wtf("PIMPAMPEET: ", "List : ");
                //for(int i = 0; i<words.size();i++){
                //    Log.wtf("PIMPAMPEET: ", "- " + words.get(i));
                //}
            }
        });
        btnNewLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvLetter.setText(randChar());
            }
        });
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(words.size() > 0){
                    tvPhrase.setText(words.get(randInt(words.size())));
                    tvLetter.setText(randChar());
                    words.remove(currentWord);
                } else{
                    Toast.makeText(getApplicationContext(), "Ord slut! Ny runda!", Toast.LENGTH_LONG).show();
                    fillWordsList();
                }

            }
        });
    }
}
