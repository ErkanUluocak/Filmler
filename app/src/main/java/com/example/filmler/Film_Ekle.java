package com.example.filmler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Film_Ekle extends AppCompatActivity {
    EditText ad, yapimYili;
    SeekBar imdb;
    Spinner tur;
    TextView deger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film__ekle);

        ad=findViewById(R.id.editText3);
        yapimYili=findViewById(R.id.editText4);
        imdb=findViewById(R.id.seekBar);
        tur=findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Depo.turler);
        tur.setAdapter(adapter);

        deger=(TextView) findViewById(R.id.textView);
        imdb=(SeekBar) findViewById(R.id.seekBar);

        imdb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
                public void onStopTrackingTouch(SeekBar seekBar){

                }
                public void onStartTrackingTouch(SeekBar seekBar){

                }
                public void onProgressChanged(SeekBar imdb,int progress,boolean fromUser){
                    deger.setText(" "+(double) progress);

                }

        });
    }
    public void btnEkle(View v){
        Intent i =new Intent();
        i.putExtra("ad",ad.getText().toString());
        i.putExtra("tur",tur.getSelectedItem().toString());
        i.putExtra("deger",deger.getText().toString());
        i.putExtra("yapimYili",yapimYili.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}
