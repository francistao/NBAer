package com.geniusvjr.nbaer.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.event.Event;
import com.geniusvjr.nbaer.ui.widgets.RevealBackgroundView;
import com.geniusvjr.nbaer.utils.AppUtils;

import butterknife.Bind;


/**
 * Created by SilenceDut on 2015/9/28.
 */
public class AboutActivity extends SwipeBackActivity  implements RevealBackgroundView.OnStateChangeListener{

    @Bind(R.id.tv_version)
    TextView mVersionTextView;
    @Bind(R.id.revealBackgroundView)
    RevealBackgroundView mRevealBackgroundView;
    @Bind(R.id.aboutView)
    View aboutView;

    public static void navigateFrom(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void initViews() {
        super.initViews();
        setTitle();
        setupRevealBackground();
    }

    @Override
    void setTitle() {
        mToolbar.setTitle(getResources().getString(R.string.about));
        mVersionTextView.setText("Version " + AppUtils.getVersionName(this));
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_about;
    }


    public void onMultipleClick(final View view) {

    }

    private void setupRevealBackground() {
        mRevealBackgroundView.setOnStateChangeListener(this);
        int screenWidth = this.getWindowManager().getDefaultDisplay().getWidth();
        final int[] startingLocation = {screenWidth,0};
        mRevealBackgroundView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mRevealBackgroundView.getViewTreeObserver().removeOnPreDrawListener(this);
                mRevealBackgroundView.startFromLocation(startingLocation);
                return true;
            }
        });

    }

    @Override
    public void onStateChange(int state) {

        if (RevealBackgroundView.STATE_FINISHED == state) {
            aboutView.setVisibility(View.VISIBLE);
        }else {
            aboutView.setVisibility(View.INVISIBLE);
        }
    }


    public void onEventMainThread(Event event) {

    }

}
