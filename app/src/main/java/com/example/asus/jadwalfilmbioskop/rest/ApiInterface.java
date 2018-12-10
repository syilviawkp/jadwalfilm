package com.example.asus.jadwalfilmbioskop.rest;

import com.example.asus.jadwalfilmbioskop.model.Film;
import com.example.asus.jadwalfilmbioskop.model.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<FilmResponse> getTopRatedMovies(@Query("api_key") String apiKey);

}
