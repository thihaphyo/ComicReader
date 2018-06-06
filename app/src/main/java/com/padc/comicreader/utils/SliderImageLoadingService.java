package com.padc.comicreader.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.padc.bannerslider.ss.com.bannerslider.ImageLoadingService;
import com.padc.comicreader.R;


/**
 * Created by Phyo Thiha on 6/6/18.
 */
public class SliderImageLoadingService implements ImageLoadingService {

    private Context context;

    public SliderImageLoadingService(Context context){
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().centerCrop())
                .into(imageView);
    }

    @Override
    public void loadImage(int resource, ImageView imageView) {

        int width = getDisplay().widthPixels;
        Glide.with(context)
                .load(resource)
                .apply(new RequestOptions().override(width,290).centerCrop())
                .into(imageView);

    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.placeholder_comics)
                        .error(R.drawable.placeholder_comics))
                .into(imageView);

    }

    public DisplayMetrics getDisplay(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        return displayMetrics;
    }
}
