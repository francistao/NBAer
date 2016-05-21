package com.geniusvjr.nbaer.ui.fragment.playersort;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.db.chart.view.BarChartView;
import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.event.StatEvent;
import com.geniusvjr.nbaer.ui.fragment.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by dream on 16/5/21.
 */
public class BarFragment extends BaseFragment{

    @Bind(R.id.cardItem)
    View mCardItem;
    @Bind(R.id.barchart1)
    BarChartView mStatChart;
    @Bind(R.id.rl_change)
    View mChangeLayout;
    @Bind(R.id.type)
    TextView mTypeTV;
    @Bind(R.id.change)
    ImageView mChange;
    private static final String STATKIND="STATKIND";
    private static final String CURRENTCOLOR="CURRENTCOLOR";
    private static final int PRECOLOR= Color.parseColor("#bcaaa4");
    private static final int CHART_TEXT_COLOR=Color.parseColor("#ffffff");
    private static final int STEP=2;
    private boolean mIsAnimating;
    private int mCurrentColor;
    private String mStatKind;
    private boolean mShowDaily=true;
    private String[] mLables;
    private String[] mPlayerUrls;
    private float [] mStatValues ;
    private String[] mPlayerUrlsDaily;
    private String[] mLablesDaily;
    private float [] mStatValuesDaily;
    private String[] mLablesEverage;
    private String[] mPlayerUrlsEverage;
    private float [] mStatValuesEverage ;
    private int mMax=16;
    Paint gridPaint;
    BarChartView barChart;

    public static BarFragment newInstace(String statKind,int currentColor){
        BarFragment barFragment = new BarFragment();
        Bundle args = new Bundle();
        args.putString(STATKIND, statKind);
        args.putInt(CURRENTCOLOR, currentColor);
        barFragment.setArguments(args);
        return barFragment;
    }

    @Override
    protected void initViews() {
        parseArguments();
        mChangeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLables != null && mStatValues != null){

                }
            }
        });
    }

    private void parseArguments() {
        Bundle args = getArguments();
        if(args == null){
            return;
        }
        mStatKind = args.getString(STATKIND);
        mCurrentColor = args.getInt(CURRENTCOLOR);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_bar;
    }


    public void onEventMainThread(StatEvent statEvent){
        if(mStatKind.equals(statEvent.getStatKind())){
            mLablesDaily = statEvent.getLables()[0];
            mLablesEverage=statEvent.getLables()[1];
            mPlayerUrlsDaily=statEvent.getPlayerUrls()[0];
            mPlayerUrlsEverage=statEvent.getPlayerUrls()[1];
            mStatValuesDaily=statEvent.getStatValues()[0];
            mStatValuesEverage=statEvent.getStatValues()[1];
            if(barChart != null){
                mShowDaily = true;

            }
        }
    }
}
