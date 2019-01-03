package com.example.a84965.musicplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.model.PlayList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayListAdapter extends ArrayAdapter<PlayList> {
    Context context;
    public PlayListAdapter(@NonNull Context context, int resource, @NonNull List<PlayList> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txtTenPlaylist;
        ImageView imgBackground,imgPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layout_play_list,null);
            viewHolder = new ViewHolder();
            viewHolder.txtTenPlaylist = convertView.findViewById(R.id.txtTenPlaylist);
            viewHolder.imgBackground = convertView.findViewById(R.id.imageBackgroundPlaylist);
            viewHolder.imgPlaylist = convertView.findViewById(R.id.imageViewPlaylist);
            convertView.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) convertView.getTag();
        }

        PlayList playList = getItem(position);
        Picasso.get()
                .load(playList.getHinh())
                .into(viewHolder.imgBackground);
        Picasso.get()
                .load(playList.getIcon())
                .into(viewHolder.imgPlaylist);
        viewHolder.txtTenPlaylist.setText(playList.getTen());


        return convertView;
    }
}
