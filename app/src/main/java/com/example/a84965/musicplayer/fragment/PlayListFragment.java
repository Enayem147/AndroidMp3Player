package com.example.a84965.musicplayer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.activity.SongListActivity;
import com.example.a84965.musicplayer.adapter.PlayListAdapter;
import com.example.a84965.musicplayer.model.PlayList;
import com.example.a84965.musicplayer.service.APIService;
import com.example.a84965.musicplayer.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayListFragment extends Fragment {
    View view;
    ListView listViewPlaylist;
    TextView txtTitle , txtViewMore;
    PlayListAdapter playListAdapter;
    ArrayList<PlayList> listPlayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_list,container,false);
        initControls();
        getData();
        return view;
    }

    private void initControls() {
        listViewPlaylist = view.findViewById(R.id.listView_PlayList);
        txtTitle = view.findViewById(R.id.txtTitlePlayList);
        txtViewMore = view.findViewById(R.id.txtViewMorePlayList);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<PlayList>> callBack = dataService.getPlayListForCurrentDay();
        callBack.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                listPlayList = (ArrayList<PlayList>) response.body();
                playListAdapter = new PlayListAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,listPlayList);
                listViewPlaylist.setAdapter(playListAdapter);
                setListViewHeightBasedOnChildren(listViewPlaylist);
                listViewPlaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intenPlaylist = new Intent(getActivity(), SongListActivity.class);
                        intenPlaylist.putExtra("playlist",listPlayList.get(position));
                        startActivity(intenPlaylist);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
