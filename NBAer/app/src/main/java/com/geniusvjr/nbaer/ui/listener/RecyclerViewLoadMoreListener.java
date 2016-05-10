package com.geniusvjr.nbaer.ui.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dream on 16/5/10.
 */
public class RecyclerViewLoadMoreListener extends RecyclerView.OnScrollListener{

    private LinearLayoutManager linearLayoutManager;
    private OnLoadMoreListener onLoadMoreListener;
    private int limit;

    public RecyclerViewLoadMoreListener(LinearLayoutManager linearLayoutManager, OnLoadMoreListener onLoadMoreListener, int limit) {
        this.linearLayoutManager = linearLayoutManager;
        this.onLoadMoreListener = onLoadMoreListener;
        this.limit = limit;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        //向下滑动，判断最后一个item是不是显示中
        if(linearLayoutManager.getItemCount() >= limit && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1){
            onLoadMoreListener.onLoadMore();
        }
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }
}
