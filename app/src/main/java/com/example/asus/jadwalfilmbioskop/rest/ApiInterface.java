package com.example.asus.jadwalfilmbioskop.rest;

import com.example.asus.jadwalfilmbioskop.Login;
import com.example.asus.jadwalfilmbioskop.model.Film;
import com.example.asus.jadwalfilmbioskop.model.FilmResponse;
import com.example.asus.jadwalfilmbioskop.model.User;
import com.example.asus.jadwalfilmbioskop.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("film")
    Call<FilmResponse> getTopRatedMovies();

    @GET("kategori")
    Call<FilmResponse> getFilmKategori();

    @FormUrlEncoded
    @POST("kategori/bioskop")
    Call<FilmResponse> getFilmKategoriID(@Field("id_bioskop") String bioskop);

    @FormUrlEncoded
    @POST("Login")
    Call<UserResponse> getLogin (@Field("email") String email,
                                 @Field("password") String password);

    //User
    @FormUrlEncoded
    @POST("User")
    Call<User> postUser (@Field("idUser") String idUser,
                         @Field("email") String email,
                         @Field("nama") String nama,
                         @Field("password") String password);



}
