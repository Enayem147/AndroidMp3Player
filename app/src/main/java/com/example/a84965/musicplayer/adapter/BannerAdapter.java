package com.example.a84965.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.activity.SongListActivity;
import com.example.a84965.musicplayer.model.QuangCao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> listBanner;

    public BannerAdapter(Context context, ArrayList<QuangCao> listBanner) {
        this.context = context;
        this.listBanner = listBanner;
    }

    @Override
    public int getCount() {
        return listBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_banner,null);
        ImageView imgBackground = view.findViewById(R.id.imageViewBackgroundBanner);
        ImageView imgBanner = view.findViewById(R.id.imageViewBanner);
        TextView txtTitle = view.findViewById(R.id.txtTitleBanner);
        TextView txtContent = view.findViewById(R.id.txtContentBanner);
        QuangCao quangCao = listBanner.get(position);
        //đổ dữ liệu lên view
        Picasso.get()
                .load(quangCao.getHinhanh())
                .into(imgBackground);
        Picasso.get()
                .load(quangCao.getHinhbaihat())
                .into(imgBanner);

        txtTitle.setText(quangCao.getTenbaihat());
        txtContent.setText(quangCao.getNoidung());
        container.addView(view);

        //event click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSongList = new Intent(context, SongListActivity.class);
                intentSongList.putExtra("banner",listBanner.get(position));
                context.startActivity(intentSongList);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
