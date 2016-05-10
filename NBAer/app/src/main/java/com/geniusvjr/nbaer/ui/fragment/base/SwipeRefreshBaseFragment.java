package com.geniusvjr.nbaer.ui.fragment.base;

import android.support.v4.widget.SwipeRefreshLayout;

import com.geniusvjr.nbaer.R;


/**
 * Created by dream on 16/4/30.
 */
public abstract class SwipeRefreshBaseFragment extends ToolbarBaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected void setRefreshing(){
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    /**
     * 是否刷新
     * @return
     */
    protected boolean isRefreshing(){
        return mSwipeRefreshLayout.isRefreshing();
    }

    protected void stopRefreshing(){
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void initViews() {
        super.initViews();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryLight);
    }
}
