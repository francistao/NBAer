package com.geniusvjr.nbaer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.geniusvjr.nbaer.R;

import butterknife.Bind;

/**
 * Created by dream on 16/4/30.
 */
public class MainFragment extends NewsFragment{

    private static final int ANIM_DURATION_TOOLBAR = 300;
    private static boolean mFirstAnimate = true;

    @Bind(R.id.mian_title)
    View mainTitle;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static MainFragment newInstance(){
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    protected int getTitle() {
        return 0;
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    void setAdapter() {
        mSwipeRefreshLayout.setBackgroundResource(R.color.grey50);
        mainTitle.setVisibility(View.VISIBLE);
//        mLoadAdapter = new MainA
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
