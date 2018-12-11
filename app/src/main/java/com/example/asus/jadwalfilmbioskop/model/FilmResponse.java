package com.example.asus.jadwalfilmbioskop.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmResponse {

    @SerializedName("status")
    private String  status;

    @SerializedName("result")
    private List<FilmBioskop> filmList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FilmBioskop> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<FilmBioskop> filmList) {
        this.filmList = filmList;
    }
}
