package com.padc.comicreader.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.bannerslider.ss.com.bannerslider.Slider;
import com.padc.comicreader.R;
import com.padc.comicreader.adapters.HomeSliderAdpater;
import com.padc.comicreader.adapters.NewComicsRecyclerViewAdapter;
import com.padc.comicreader.delegates.ComicListDelegate;
import com.padc.comicreader.utils.SliderImageLoadingService;



/**
 * Created by Phyo Thiha on 6/6/18.
 */
public class FragmentComicsHome extends BaseFragment implements ComicListDelegate{

    public FragmentComicsHome(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_comics_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Slider.init(new SliderImageLoadingService(getContext()));
        Slider slider = view.findViewById(R.id.bs_banner_image);
        slider.setAdapter(new HomeSliderAdpater(3));

        RecyclerView rvNewReleased = view.findViewById(R.id.rv_new_released);
        rvNewReleased.setAdapter(new NewComicsRecyclerViewAdapter(this));
        rvNewReleased.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    public void onSliderTapped() {

    }

    @Override
    public void onComicCardTapped() {

        Toast.makeText(getContext(),"You Tapped me",Toast.LENGTH_LONG).show();

    }
}
