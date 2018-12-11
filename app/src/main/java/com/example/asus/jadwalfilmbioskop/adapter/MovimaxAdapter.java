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
import com.example.asus.jadwalfilmbioskop.model.FilmBioskop;
import com.example.asus.jadwalfilmbioskop.rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovimaxAdapter extends RecyclerView.Adapter<MovimaxAdapter.ViewHolder> {

    private List<FilmBioskop> mFilm;
    private Context mContext;

    public MovimaxAdapter(List<FilmBioskop> mFilm, Context mContext) {
        this.mFilm = mFilm;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MovimaxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_detail_movimax, parent, false);
        MovimaxAdapter.ViewHolder myViewHolder = new MovimaxAdapter.ViewHolder(mView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovimaxAdapter.ViewHolder holder, int position) {
        holder.judul.setText(mFilm.get(position).getJudul());
        holder.jam.setText(mFilm.get(position).getJam());
        Picasso.with(mContext).load(ApiClient.BASE_upload+mFilm.get(position).getPoster()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return mFilm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView judul,jam;
        ImageView poster;
        public ViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txt_film);
            jam = itemView.findViewById(R.id.txt_jam_tayang);
            poster = itemView.findViewById(R.id.poster1);
        }
    }
}
