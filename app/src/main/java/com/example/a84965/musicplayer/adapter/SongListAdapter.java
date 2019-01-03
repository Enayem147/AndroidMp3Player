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

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    Context context;
    ArrayList<BaiHat> listBaiHat;

    public SongListAdapter(Context context, ArrayList<BaiHat> listBaiHat) {
        this.context = context;
        this.listBaiHat = listBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_song_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = listBaiHat.get(position);
        holder.txtTen.setText(baiHat.getTen());
        holder.txtCasi.setText(baiHat.getCasi());
        holder.txtIndex.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return listBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtIndex,txtTen,txtCasi;
        ImageView imgThich;
        public ViewHolder(View itemView) {
            super(itemView);
            txtIndex = itemView.findViewById(R.id.txtSongListIndex);
            txtTen = itemView.findViewById(R.id.txtSongListName);
            txtCasi = itemView.findViewById(R.id.txtSongListSinger);
            imgThich = itemView.findViewById(R.id.imageViewSongListLove);
        }
    }
}
