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
import com.example.a84965.musicplayer.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> listAlbum;

    public AlbumAdapter(Context context, ArrayList<Album> listAlbum) {
        this.context = context;
        this.listAlbum = listAlbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = listAlbum.get(position);
        holder.txtTenAlbum.setText(album.getTen());
        holder.txtCaSiAlbum.setText(album.getCasi());
        Picasso.get()
                .load(album.getHinh())
                .into(holder.imgHinhAlbum);
    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhAlbum;
        TextView txtTenAlbum,txtCaSiAlbum;

        public ViewHolder(View itemView) {
            super(itemView);
            imgHinhAlbum = itemView.findViewById(R.id.imageViewAlbum);
            txtTenAlbum = itemView.findViewById(R.id.txtAlbumTen);
            txtCaSiAlbum = itemView.findViewById(R.id.txtAlbumTenCaSi);
        }
    }
}
