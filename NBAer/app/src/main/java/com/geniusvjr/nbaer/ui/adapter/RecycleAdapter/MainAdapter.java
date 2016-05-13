package com.geniusvjr.nbaer.ui.adapter.RecycleAdapter;

import android.content.Context;
import android.view.ViewGroup;

import com.geniusvjr.nbaer.model.News;

import java.util.List;

/**
 * Created by dream on 16/5/10.
 */
public class MainAdapter extends LoadAdapter{


    public MainAdapter(Context mContext, List<News.NewslistEntity> mNewsList) {
        super(mContext, mNewsList);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


    protected void setAnimateEndCount(int animateEndCount){

    }
}
