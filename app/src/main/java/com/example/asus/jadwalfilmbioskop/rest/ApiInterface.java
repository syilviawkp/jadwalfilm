package com.example.asus.jadwalfilmbioskop.rest;

import com.example.asus.jadwalfilmbioskop.model.Film;
import com.example.asus.jadwalfilmbioskop.model.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("film")
    Call<FilmResponse> getTopRatedMovies();

}
