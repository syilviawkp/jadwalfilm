package com.example.asus.jadwalfilmbioskop.model;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id_film") private String id_film;
    @SerializedName("judul") private String judul;
    @SerializedName("jam") private String jam;
    @SerializedName("poster") private String poster;

    public String getId_film() {
        return id_film;
    }

    public void setId_film(String id_film) {
        this.id_film = id_film;
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
