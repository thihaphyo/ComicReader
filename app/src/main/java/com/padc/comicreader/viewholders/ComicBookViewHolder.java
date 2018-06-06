package com.padc.comicreader.viewholders;

import android.view.View;

import com.padc.comicreader.delegates.ComicListDelegate;

/**
 * Created by Phyo Thiha on 6/7/18.
 */
public class ComicBookViewHolder extends BaseViewHolder {

    private ComicListDelegate mComicListDelegate;


    public ComicBookViewHolder(ComicListDelegate comicListDelegate, View itemView) {
        super(itemView);
        mComicListDelegate = comicListDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mComicListDelegate.onComicCardTapped();
            }
        });
    }
}
