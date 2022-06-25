package com.example.filmler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GirisEkrani extends AppCompatActivity {

    EditText username;
    EditText password;
    Button buttongiris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        buttongiris    = (Button)   findViewById(R.id.button);

        buttongiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( username.getText().toString().equals("user") && password.getText().toString().equals("1234") )
                {
                    Intent myIntent = new Intent(GirisEkrani.this, AnaSayfa.class);
                    myIntent.putExtra("username", username.getText().toString());
                    GirisEkrani.this.startActivity(myIntent);
                }
                else
                {
                    Toast.makeText(GirisEkrani.this, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
