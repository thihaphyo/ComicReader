package com.padc.bannerslider.ss.com.bannerslider;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.padc.bannerslider.R;
import com.padc.bannerslider.ss.com.bannerslider.event.OnSlideChangeListener;
import com.padc.bannerslider.ss.com.bannerslider.indicators.CircleIndicator;
import com.padc.bannerslider.ss.com.bannerslider.indicators.DashIndicator;
import com.padc.bannerslider.ss.com.bannerslider.indicators.IndicatorShape;
import com.padc.bannerslider.ss.com.bannerslider.indicators.RoundSquareIndicator;
import com.padc.bannerslider.ss.com.bannerslider.indicators.SquareIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * @author S.Shahini
 * @since 11/26/16
 */
class SlideIndicatorsGroup extends LinearLayout implements OnSlideChangeListener {
    private static final String TAG = "SlideIndicatorsGroup";
    private final Context context;
    private int slidesCount;
    private Drawable selectedSlideIndicator;
    private Drawable unselectedSlideIndicator;
    private int defaultIndicator;
    private int indicatorSize;
    private int indicatorBackGroundColor;
    private boolean mustAnimateIndicators = true;
    private List<IndicatorShape> indicatorShapes = new ArrayList<>();

    public SlideIndicatorsGroup(Context context, Drawable selectedSlideIndicator, Drawable unselectedSlideIndicator, int defaultIndicator, int indicatorSize, boolean mustAnimateIndicators,int indicatorBackGroundColor) {
        super(context);
        this.context = context;
        this.selectedSlideIndicator = selectedSlideIndicator;
        this.unselectedSlideIndicator = unselectedSlideIndicator;
        this.defaultIndicator = defaultIndicator;
        this.indicatorSize = indicatorSize;
        this.mustAnimateIndicators = mustAnimateIndicators;
        this.indicatorBackGroundColor = indicatorBackGroundColor;
        setup();
    }

    public void setSlides(int slidesCount) {
        removeAllViews();
        indicatorShapes.clear();
        this.slidesCount = 0;
        for (int i = 0; i < slidesCount; i++) {
            onSlideAdd();
        }
        this.slidesCount = slidesCount;
    }

    public void onSlideAdd() {
        this.slidesCount += 1;
        addIndicator();
    }

    private void addIndicator() {
        IndicatorShape indicatorShape;
        if (selectedSlideIndicator != null && unselectedSlideIndicator != null) {
            indicatorShape = new IndicatorShape(context, indicatorSize, mustAnimateIndicators) {
                @Override
                public void onCheckedChange(boolean isChecked) {
                    super.onCheckedChange(isChecked);
                    if (isChecked) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            setBackground(selectedSlideIndicator);
                        } else {
                            setBackgroundDrawable(selectedSlideIndicator);
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            setBackground(unselectedSlideIndicator);
                        } else {
                            setBackgroundDrawable(unselectedSlideIndicator);
                        }
                    }
                }
            };
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                indicatorShape.setBackground(unselectedSlideIndicator);
            } else {
                indicatorShape.setBackgroundDrawable(unselectedSlideIndicator);
            }
            indicatorShapes.add(indicatorShape);
            addView(indicatorShape);

        } else {
            switch (defaultIndicator) {
                case IndicatorShape.SQUARE:
                    indicatorShape = new SquareIndicator(context, indicatorSize, mustAnimateIndicators);
                    indicatorShapes.add(indicatorShape);
                    addView(indicatorShape);
                    break;
                case IndicatorShape.ROUND_SQUARE:
                    indicatorShape = new RoundSquareIndicator(context, indicatorSize, mustAnimateIndicators);
                    indicatorShapes.add(indicatorShape);
                    addView(indicatorShape);
                    break;
                case IndicatorShape.DASH:
                    indicatorShape = new DashIndicator(context, indicatorSize, mustAnimateIndicators);
                    indicatorShapes.add(indicatorShape);
                    addView(indicatorShape);
                    break;

                case IndicatorShape.CIRCLE:
                    indicatorShape = new CircleIndicator(context, indicatorSize, mustAnimateIndicators);
                    indicatorShapes.add(indicatorShape);
                    addView(indicatorShape);
                    break;
                default:
                    break;
            }
        }
    }

    //Modified by PTH
    public void setup() {

        changeindicatorBackGroundColor();
        setOrientation(LinearLayout.HORIZONTAL);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        setHorizontalGravity(Gravity.CENTER);
        int padding = getResources().getDimensionPixelSize(R.dimen.indicator_view_padding);
        setPadding(padding,padding,padding,padding);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
    }

    private void changeindicatorBackGroundColor(){

        setBackgroundColor(indicatorBackGroundColor);
    }

    @Override
    public void onSlideChange(int selectedSlidePosition) {
        Log.i(TAG, "onSlideChange: "+selectedSlidePosition);
        for (int i = 0; i < indicatorShapes.size(); i++) {
            if (i == selectedSlidePosition) {
                indicatorShapes.get(i).onCheckedChange(true);
            } else {
                indicatorShapes.get(i).onCheckedChange(false);
            }
        }
    }

    public void setMustAnimateIndicators(boolean shouldAnimate) {
        this.mustAnimateIndicators = shouldAnimate;
        for (IndicatorShape indicatorShape :
                indicatorShapes) {
            indicatorShape.setMustAnimateChange(shouldAnimate);
        }
    }

}
