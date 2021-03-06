package com.padc.bannerslider.ss.com.bannerslider.adapters;


import com.padc.bannerslider.ss.com.bannerslider.SlideType;
import com.padc.bannerslider.ss.com.bannerslider.viewholder.ImageSlideViewHolder;

/**
 * @author S.Shahini
 * @since 3/4/18
 */

public abstract class SliderAdapter {
    public abstract int getItemCount();

    public final SlideType getSlideType(int position) {
        return SlideType.IMAGE;
    }

    public abstract void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder);
}
