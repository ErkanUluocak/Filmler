package com.example.filmler;

public class Film {
    private String ad;
    private String tur;
    private String imdb;
    private String yapimYili;

    public Film(String ad, String tur, String imdb, String yapimYili) {
        this.ad = ad;
        this.tur = tur;
        this.imdb = imdb;
        this.yapimYili = yapimYili;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getYapimYili() {
        return yapimYili;
    }

    public void setYapimYili(String yapimYili) {
        this.yapimYili = yapimYili;
    }
}
