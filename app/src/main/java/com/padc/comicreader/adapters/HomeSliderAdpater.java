package com.padc.comicreader.adapters;


import com.padc.bannerslider.ss.com.bannerslider.viewholder.ImageSlideViewHolder;

/**
 * Created by Phyo Thiha on 6/6/18.
 */
public class HomeSliderAdpater extends BaseSliderAdapter {

    private int mNumOfItems = 0;

    public HomeSliderAdpater(int numOfItems){
        mNumOfItems = numOfItems;
    }
    @Override
    public int getItemCount() {
        return mNumOfItems;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {

        switch (position) {
            case 0:
                imageSlideViewHolder.bindImageSlide("http://multiverse-magazine.com/wp-content/uploads/2013/07/IronManFatalFrontier_1_Cover.jpg");
                break;
            case 1:
                imageSlideViewHolder.bindImageSlide("https://nerdist.com/wp-content/uploads/2016/02/20160210_dancave_deadpoolthanos_feature.jpg");
                break;
            case 2:
                imageSlideViewHolder.bindImageSlide("https://pre00.deviantart.net/150a/th/pre/f/2013/256/b/2/deadpool_custom_wallpaper_1st_edit__by_undeadpixelarmy-d6m5yv3.jpg");
                break;
        }

    }
}
