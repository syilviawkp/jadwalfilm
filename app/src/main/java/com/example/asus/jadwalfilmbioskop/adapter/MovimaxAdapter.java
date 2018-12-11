package com.example.asus.jadwalfilmbioskop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.jadwalfilmbioskop.R;
import com.example.asus.jadwalfilmbioskop.model.Film;

import java.util.ArrayList;
import java.util.List;

public class MovimaxAdapter extends RecyclerView.Adapter<MovimaxAdapter.ViewHolder> {
    private List<Film> rvData;
    private Context mContext;

    public MovimaxAdapter(List<Film> rvData, Context mContext) {
        this.rvData = rvData;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView namaFilm, jamTayang;
        public ViewHolder(View v) {
            super(v);
            namaFilm = (TextView) v.findViewById(R.id.txt_film);
            jamTayang = (TextView) v.findViewById(R.id.txt_jam_tayang);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_detail_movimax, parent,false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
//        final String name = rvData.get(position);
//        holder.namaFilm.setText(rvData.get(position));
//        holder.jamTayang.setText(rvData.get(position));
        holder.namaFilm.setText(rvData.get(position).getJudul());
        holder.jamTayang.setText(rvData.get(position).getJam());

    }
    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }
}
