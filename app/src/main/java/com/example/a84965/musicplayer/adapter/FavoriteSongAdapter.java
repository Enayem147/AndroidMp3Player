package com.example.a84965.musicplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.model.BaiHat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteSongAdapter extends RecyclerView.Adapter<FavoriteSongAdapter.ViewHolder>  {

    Context context;
    ArrayList<BaiHat> listBaiHat;


    public FavoriteSongAdapter(Context context, ArrayList<BaiHat> listBaiHat) {
        this.context = context;
        this.listBaiHat = listBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_favorite_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = listBaiHat.get(position);
        holder.txtTen.setText(baiHat.getTen());
        holder.txtCaSi.setText(baiHat.getCasi());
        Picasso.get()
                .load(baiHat.getHinh())
                .into(holder.imgHinh);
    }

    @Override
    public int getItemCount() {
        return listBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTen,txtCaSi;
        ImageView imgHinh , imgThich;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.txtFavoriteSongTenBH);
            txtCaSi = itemView.findViewById(R.id.txtFavoriteSongTenCasi);
            imgHinh = itemView.findViewById(R.id.imageViewFavoriteSong);
            imgThich = itemView.findViewById(R.id.imageViewFavoriteSongLove);
        }
    }
}
