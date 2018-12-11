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

public class DetailMovimax extends AppCompatActivity {

    ImageView imgHome1, imgProfil1, imgBack1;
    private ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Film> mFilm = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movimax);



        imgHome1 = findViewById(R.id.imgHome1);
        imgProfil1 = findViewById(R.id.imgProfil1);
        imgBack1 = findViewById(R.id.imgBack1);

        imgHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(DetailMovimax.this, Home.class);
                startActivity(a);
            }
        });

        imgProfil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(DetailMovimax.this, Profil.class);
                startActivity(b);
            }
        });

        imgBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(DetailMovimax.this, Home.class);
                startActivity(c);
            }
        });

        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        recycler1.setLayoutManager(new LinearLayoutManager(this));
        mApiInterface  = ApiClient.getClient().create(ApiInterface.class);
        Call<FilmResponse> call = mApiInterface.getTopRatedMovies();

        call.enqueue(new Callback<FilmResponse>() {
            @Override
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                mFilm = response.body().getFilmList();

                Log.e("Hai",response.body().getStatus());

                mAdapter = new MovimaxAdapter(mFilm, getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {

            }
        });





    }
}
