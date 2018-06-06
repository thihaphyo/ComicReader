package com.padc.comicreader.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.comicreader.R;
import com.padc.comicreader.delegates.ComicListDelegate;
import com.padc.comicreader.viewholders.ComicBookViewHolder;

/**
 * Created by Phyo Thiha on 6/7/18.
 */
public class NewComicsRecyclerViewAdapter extends BaseAdapter {

    private ComicListDelegate mComicListDelegate;

    public NewComicsRecyclerViewAdapter(ComicListDelegate comicListDelegate){

        mComicListDelegate = comicListDelegate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v =layoutInflater.inflate(R.layout.viewholder_comicbook
                ,parent,false);
        return new ComicBookViewHolder(mComicListDelegate,v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
