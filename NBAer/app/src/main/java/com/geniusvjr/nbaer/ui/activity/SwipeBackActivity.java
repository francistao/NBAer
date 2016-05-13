package com.geniusvjr.nbaer.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.ui.widgets.SwipeBackLayout;

import butterknife.Bind;


/**
 * Created by dream on 16/4/30.
 */
public abstract class SwipeBackActivity extends BaseActivity{

    @Bind(R.id.swipBackLayout)
    SwipeBackLayout mSwipeBackLayout;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    abstract void setTitle();

    @Override
    protected void initViews() {
        initToolBar();
        mSwipeBackLayout.setCallBack(new SwipeBackLayout.Callback() {
            @Override
            public void onFinish() {
                finish();
            }
        });
    }

    protected void initToolBar(){
        setTitle();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
