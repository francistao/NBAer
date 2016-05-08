package com.geniusvjr.nbaer.ui.adapter.RecycleAdapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.geniusvjr.nbaer.app.AppService;
import com.geniusvjr.nbaer.event.NewsAnimatEndEvent;
import com.geniusvjr.nbaer.model.News;
import com.geniusvjr.nbaer.utils.NumericalUtil;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by dream on 16/5/5.
 */
public abstract class LoadAdapter extends RecyclerView.Adapter<LoadAdapter.BaseViewHolder>{


    private static final int ANIMATED_ITEMS_DURATION = 1000;
    private int lastAnimatedPosition = -1;
    protected Boolean mLoading = false;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<News.NewslistEntity> mNewsList;
    private boolean mAnimate = true;
    protected int mAnimateEndCount;

    public LoadAdapter(Context mContext, List<News.NewslistEntity> mNewsList) {
        super();
        this.mContext = mContext;
        this.mNewsList = mNewsList;
        mInflater = LayoutInflater.from(mContext);
    }


    enum VIEWTYPE{
        NORMAL(0),NOPIC(1),MOREPIC(2),LOADMORE(3),ERROR(4);
        private int viewType;
        VIEWTYPE(int viewType) {
            this.viewType=viewType;
        }

        public int getViewType() {
            return viewType;
        }
    }

    protected void setAnimateEndCount(int animateEndCount){
        this.mAnimateEndCount = animateEndCount;
    }


    @Override
    public int getItemViewType(int position) {
        int itemType;
        if(mNewsList == null || mNewsList.get(position) == null){
            itemType = VIEWTYPE.ERROR.getViewType();
        }else if(position == getItemCount() - 1){
            itemType = VIEWTYPE.LOADMORE.getViewType();
        }else if(mNewsList.get(position).getImgUrlList().size() == 0){
            itemType = VIEWTYPE.NOPIC.getViewType();
        }else if(mNewsList.get(position).getImgUrlList().size() >= 4){
            itemType = VIEWTYPE.MOREPIC.getViewType();
        }else {
            itemType = VIEWTYPE.NORMAL.getViewType();
        }
        return itemType;
    }

    @Override
    public int getItemCount() {
        return mNewsList == null ? 0 : mNewsList.size();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.update(position);
        if(mAnimate){
            runEnterAnimation(holder.itemView, position);
        }
    }

    protected void runEnterAnimation(View itemView, final int position){
        if(position > lastAnimatedPosition){
            lastAnimatedPosition = position;
            itemView.setTranslationY(NumericalUtil.getScreenHeight(mContext));
            itemView.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.0f))
                    .setDuration(ANIMATED_ITEMS_DURATION)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            if(position == mAnimateEndCount || position >= getItemCount() - 1){
                                AppService.getInstance().getBus().post(new NewsAnimatEndEvent());
                            }
                        }
                    })
                    .start();
        }
    }


    protected abstract static class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected abstract void update(int position);
    }

    public void setLoading(boolean loading){
        this.mLoading = loading;
    }

    public void setAnimate(boolean animate){
        this.mAnimate = animate;
    }

    //是否能加载更多
    public boolean canLoadMore(){
        return !mLoading;
    }

    //刷新列表
    public void updateItem(){
        notifyDataSetChanged();
    }

    protected abstract class EntityHolder extends BaseViewHolder implements View.OnClickListener{

        News.NewslistEntity newEntity;
        public EntityHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void update(int position) {
            newEntity = mNewsList.get(position);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(mContext, )
        }
    }


}
