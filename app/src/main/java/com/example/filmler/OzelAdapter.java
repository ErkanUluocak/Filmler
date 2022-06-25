package com.example.filmler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OzelAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Film> filmArrayList;

    public OzelAdapter(Context context, ArrayList<Film> filmArrayList) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.filmArrayList = filmArrayList;
    }

    @Override
    public int getCount() {
        return filmArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.satir_layout,parent,false);
        TextView txt_ad=convertView.findViewById(R.id.satir_ad);
        //TextView txt_tur=convertView.findViewById(R.id.satir_tur);
        ImageView img_tur=convertView.findViewById(R.id.satir_resim);
        TextView txt_imdb=convertView.findViewById(R.id.satir_imdb);
        TextView txt_yapimYili=convertView.findViewById(R.id.satir_yapimyili);
        Film f=filmArrayList.get(position);
        txt_ad.setText(f.getAd());
        txt_imdb.setText(f.getImdb());
        txt_yapimYili.setText(f.getYapimYili());
        //txt_tur.setText(f.getTur());

        if(f.getTur().equals("Aksiyon")){
            img_tur.setImageResource(R.drawable.aksiyon);
        }
        else if(f.getTur().equals("Bilim Kurgu")){
            img_tur.setImageResource(R.drawable.bilimkurgu);
        }
        else if(f.getTur().equals("Macera")){
            img_tur.setImageResource(R.drawable.macera);
        }
        else if(f.getTur().equals("Animasyon")){
            img_tur.setImageResource(R.drawable.animasyon);
        }
        else if(f.getTur().equals("Komedi")){
            img_tur.setImageResource(R.drawable.komedi);
        }
        else if(f.getTur().equals("Aşk")){
            img_tur.setImageResource(R.drawable.ask);
        }
        return convertView;
    }
}
