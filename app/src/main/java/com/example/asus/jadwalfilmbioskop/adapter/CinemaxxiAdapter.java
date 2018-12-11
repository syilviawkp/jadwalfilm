package com.example.asus.jadwalfilmbioskop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.jadwalfilmbioskop.R;
import com.example.asus.jadwalfilmbioskop.model.Film;
import com.example.asus.jadwalfilmbioskop.rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CinemaxxiAdapter extends RecyclerView.Adapter<CinemaxxiAdapter.ViewHolder> {
    private List<Film> aFilm;
    private Context aContext;

    public CinemaxxiAdapter(List<Film> aFilm, Context aContext) {
        this.aFilm = aFilm;
        this.aContext = aContext;
    }

    @NonNull
    @Override
    public CinemaxxiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_detail_cinemaxxi, parent, false);
        CinemaxxiAdapter.ViewHolder myViewHolder = new CinemaxxiAdapter.ViewHolder(mView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaxxiAdapter.ViewHolder holder, int position) {
        holder.judul.setText(aFilm.get(position).getJudul());
        holder.jam.setText(aFilm.get(position).getJam());
        Picasso.with(aContext).load(ApiClient.BASE_upload+aFilm.get(position).getPoster()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return aFilm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView judul,jam;
        ImageView poster;
        public ViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txt_film3);
            jam = itemView.findViewById(R.id.txt_jam_tayang3);
            poster = itemView.findViewById(R.id.poster3);
        }
    }
}

