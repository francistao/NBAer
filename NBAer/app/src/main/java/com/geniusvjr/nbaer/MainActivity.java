package com.geniusvjr.nbaer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geniusvjr.nbaer.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
