package com.geniusvjr.nbaer.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dream on 16/4/23.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected abstract void initViews();
    protected abstract int getContentViewId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

    }
}
