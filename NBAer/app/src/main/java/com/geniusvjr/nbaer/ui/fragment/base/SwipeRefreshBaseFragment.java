package com.geniusvjr.nbaer.ui.fragment.base;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by dream on 16/4/30.
 */
public abstract class SwipeRefreshBaseFragment extends ToolbarBaseFragment{

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected void setRefreshing(){
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);

            }
        });
    }

}
