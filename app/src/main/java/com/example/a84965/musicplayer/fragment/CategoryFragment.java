package com.example.a84965.musicplayer.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.model.ChuDe;
import com.example.a84965.musicplayer.model.TheLoai;
import com.example.a84965.musicplayer.model.TheLoaiChuDe;
import com.example.a84965.musicplayer.service.APIService;
import com.example.a84965.musicplayer.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    View view;
    ArrayList<TheLoai> listTheLoai;
    ArrayList<ChuDe> listChuDe;
    HorizontalScrollView horizontalScrollView;
    TextView txtViewMore;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category,container,false);
        initControls();
        getData();
        return view;
    }

    private void initControls() {
        horizontalScrollView = view.findViewById(R.id.horozontalScrollView);
        txtViewMore = view.findViewById(R.id.txtViewMoreCategory);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<TheLoaiChuDe> callBack = dataService.getTheLoaiChuDe();
        callBack.enqueue(new Callback<TheLoaiChuDe>() {
            @Override
            public void onResponse(Call<TheLoaiChuDe> call, Response<TheLoaiChuDe> response) {
                TheLoaiChuDe theLoaiChuDe = response.body();

                final ArrayList<ChuDe> listChuDe = new ArrayList<>();
                listChuDe.addAll(theLoaiChuDe.getChuDe());

                final ArrayList<TheLoai> listTheLoai = new ArrayList<>();
                listTheLoai.addAll(theLoaiChuDe.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);
                // đổ dữ liệu chủ đề
                for (int i=0;i<(listChuDe.size());i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(listChuDe.get(i).getHinhchude() != null){
                        Picasso.get()
                                .load(listChuDe.get(i).getHinhchude())
                                .into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                // đổ dữ liệu thể loại
                for (int j=0;j<(listTheLoai.size());j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(listTheLoai.get(j).getHinhtheloai() != null){
                        Picasso.get()
                                .load(listTheLoai.get(j).getHinhtheloai())
                                .into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);

            }

            @Override
            public void onFailure(Call<TheLoaiChuDe> call, Throwable t) {

            }
        });
    }


}
