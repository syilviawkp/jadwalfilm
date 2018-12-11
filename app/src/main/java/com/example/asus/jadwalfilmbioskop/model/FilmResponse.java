package com.example.asus.jadwalfilmbioskop.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmResponse {

    @SerializedName("status")
    private String  status;

    @SerializedName("result")
    private List<Film> filmList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
