package com.geniusvjr.nbaer.ui.fragment;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;

import com.geniusvjr.nbaer.model.News;
import com.geniusvjr.nbaer.ui.fragment.base.SwipeRefreshBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 16/5/3.
 */
public abstract class NewsFragment extends SwipeRefreshBaseFragment{

    RecyclerView mNewsListView;

    CoordinatorLayout newsContainer;

    protected List<News.NewslistEntity> mNewsListEntity = new ArrayList<News.NewslistEntity>();

}
