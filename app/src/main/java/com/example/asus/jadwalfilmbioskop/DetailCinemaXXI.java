package com.example.asus.jadwalfilmbioskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.jadwalfilmbioskop.adapter.MovimaxAdapter;
import com.example.asus.jadwalfilmbioskop.model.Film;
import com.example.asus.jadwalfilmbioskop.model.FilmResponse;
import com.example.asus.jadwalfilmbioskop.rest.ApiClient;
import com.example.asus.jadwalfilmbioskop.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailCinemaXXI extends AppCompatActivity {
    ImageView imgHome3, imgProfil3, imgBack3;
    private ApiInterface aApiInterface;
    private RecyclerView aRecyclerView;
    private RecyclerView.Adapter aAdapter;
    private RecyclerView.LayoutManager aLayoutManager;
    private List<Film> aFilm = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cinema_xxi);

        imgHome3 = findViewById(R.id.imgHome3);
        imgProfil3 = findViewById(R.id.imgProfil3);
        imgBack3 = findViewById(R.id.imgBack3);

        imgHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(DetailCinemaXXI.this, Home.class);
                startActivity(a);
            }
        });

        imgProfil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(DetailCinemaXXI.this, Profil.class);
                startActivity(b);
            }
        });

        imgBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(DetailCinemaXXI.this, Home.class);
                startActivity(c);
            }
        });

        aRecyclerView = findViewById(R.id.recycler3);
        aRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        recycler1.setLayoutManager(new LinearLayoutManager(this));
        aApiInterface  = ApiClient.getClient().create(ApiInterface.class);
        Call<FilmResponse> call = aApiInterface.getTopRatedMovies();

        call.enqueue(new Callback<FilmResponse>() {
            @Override
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                aFilm = response.body().getFilmList();

                Log.e("Hai",response.body().getStatus());

                aAdapter = new MovimaxAdapter(aFilm, getApplicationContext());
                aRecyclerView.setAdapter(aAdapter);
            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {

            }
        });

    }
}
