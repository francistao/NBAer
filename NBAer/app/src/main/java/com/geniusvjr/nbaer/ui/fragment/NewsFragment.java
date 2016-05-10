package com.geniusvjr.nbaer.ui.fragment;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.event.NewsAnimatEndEvent;
import com.geniusvjr.nbaer.event.NewsEvent;
import com.geniusvjr.nbaer.model.News;
import com.geniusvjr.nbaer.ui.adapter.RecycleAdapter.LoadAdapter;
import com.geniusvjr.nbaer.ui.fragment.base.SwipeRefreshBaseFragment;
import com.geniusvjr.nbaer.ui.listener.RecyclerViewLoadMoreListener;
import com.geniusvjr.nbaer.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by dream on 16/5/3.
 */
public abstract class NewsFragment extends SwipeRefreshBaseFragment implements RecyclerViewLoadMoreListener.OnLoadMoreListener {

    @Bind(R.id.rv_news)
    RecyclerView mNewsListView;
    @Bind(R.id.newsContainer)
    CoordinatorLayout newsContainer;

    protected List<News.NewslistEntity> mNewsListEntity = new ArrayList<News.NewslistEntity>();
    protected LoadAdapter mLoadAdapter;
    protected String mNewsId = "";

    @Override
    protected int getTitle() {
        return 0;
    }

    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mNewsListView.getContext());
        mNewsListView.setLayoutManager(linearLayoutManager);
        mNewsListView.addOnScrollListener(new RecyclerViewLoadMoreListener(linearLayoutManager, this, 0));
        mNewsListView.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(mSwipeRefreshLayout.isRefreshing()){
                            return true;
                        }else {
                            return false;
                        }
                    }
                }
        );
        setAdapter();
    }

    protected void stopAll(){
        stopRefreshing();
        stopLoading();
    }

    protected void stopLoading(){
        mLoadAdapter.notifyItemChanged(mLoadAdapter.getItemCount() - 1);
        mLoadAdapter.setLoading(false);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main;
    }

    protected  void updateView(NewsEvent newsEvent){
        if(Constant.Result.FAIL.equals(newsEvent.getmEventResult())){
            if(newsEvent.getNewsWay().equals(Constant.GETNEWSWAY.INIT)){
                setRefreshing();
            }else {
                stopAll();
                AppUtils.showSnackBar(newsContainer, R.string.load_fail);
            }
        }else {
            News news = newsEvent.getNews();
            mNewsId = news.getNextId();
            switch (newsEvent.getNewsWay()){
                case INIT:
                    mNewsListEntity.clear();
                    mNewsListEntity.addAll(news.getNewslist());
                break;
                case UPDATE:
                    mNewsListEntity.clear();
                    mNewsListEntity.addAll(news.getNewslist());
                    stopRefreshing();
                    mLoadAdapter.setAnimate(false);
                    break;
                case LOADMORE:
                    mNewsListEntity.addAll(news.getNewslist());
                    stopLoading();
                    mLoadAdapter.setAnimate(false);
                    break;
                default:
                    break;
            }
            mLoadAdapter.updateItem();
            if(Constant.GETNEWSWAY.UPDATE.equals(newsEvent.getNewsWay())){
                AppUtils.showSnackBar(newsContainer, R.string.load_success);
            }
        }
    }

    public void onEventMainThread(NewsAnimatEndEvent newsAnimatEndEvent){
        setRefreshing();
    }
    abstract void setAdapter();
}
