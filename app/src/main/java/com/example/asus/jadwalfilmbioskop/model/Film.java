package com.example.asus.jadwalfilmbioskop.model;

import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("idFilm")
    private int idFilm;

    @SerializedName("judul")
    private String judul;

    @SerializedName("jam")
    private String jam;

    @SerializedName("poster")
    private String poster;

    public Film(int idFilm, String judul, String jam, String poster) {
        this.idFilm = idFilm;
        this.judul = judul;
        this.jam = jam;
        this.poster = poster;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
