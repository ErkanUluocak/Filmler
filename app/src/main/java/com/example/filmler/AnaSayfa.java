package com.example.filmler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AnaSayfa extends AppCompatActivity {
    ListView listView;
    ArrayList<Film> filmler;
    OzelAdapter ozelAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Toast.makeText(this, "Hoşgeldin "+ username, Toast.LENGTH_SHORT).show();
        listView=findViewById(R.id.listView);
        filmler=new ArrayList<>();



        ozelAdapter=new OzelAdapter(this,filmler);
        listView.setAdapter(ozelAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_cikis) {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Uyarı");
            alert.setMessage("Çıkış yapmak istiyor musunuz?");
            alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Çıkış yapılmadı", Toast.LENGTH_SHORT).show();
                }
            });
            alert.show();
        }
        if (item.getItemId()==R.id.item_ayarlar){
            Intent gecis=new Intent(AnaSayfa.this,Ayarlar.class);
            startActivity(gecis);
            finish();
        }
        if(item.getItemId()==R.id.item_ekle){
            Intent i=new Intent(this,Film_Ekle.class);
            startActivityForResult(i,55);
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==55 && resultCode==RESULT_OK) {
            String ad =data.getStringExtra("ad");
            String tur =data.getStringExtra("tur");
            String deger =data.getStringExtra("deger");
            String yapimYili =data.getStringExtra("yapimYili");

            Film YeniFilm =new Film(ad,tur,deger,yapimYili);
            filmler.add(YeniFilm);
            ozelAdapter.notifyDataSetChanged();
        }
    }

}

