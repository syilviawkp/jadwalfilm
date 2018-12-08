package com.example.asus.jadwalfilmbioskop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovimaxAdapter extends RecyclerView.Adapter<MovimaxAdapter.ViewHolder> {
    private ArrayList<String> rvData;
    public MovimaxAdapter(ArrayList<String> inputData) {
        rvData = inputData;
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
        final String name = rvData.get(position);
        holder.namaFilm.setText(rvData.get(position));
        holder.jamTayang.setText(rvData.get(position));

    }
    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }
}
