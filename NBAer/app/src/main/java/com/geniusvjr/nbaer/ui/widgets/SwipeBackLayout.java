package com.geniusvjr.nbaer.ui.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by dream on 16/4/30.
 */
public class SwipeBackLayout extends FrameLayout{

    private ViewDragHelper mViewDragHelper;
    private View mContentView;
    private int mContentWidth;
    private int mMoveLeft;
    private boolean isClose = false;
    private boolean isEdgeDrag = false;
    private Callback mCallBack;
    private Drawable mShadowLeft;
    private static final int FULL_ALPHA = 255;
    private static final int DEFAULT_SCRIM_COLOR = 0x99000000;
    private int mScrimColor = DEFAULT_SCRIM_COLOR;
    private float mScrimOpacity;
    private float mScrollPercent;
    private Rect mTmpRect = new Rect();

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }


    //设置回调接口
    public void setCallBack(Callback callBack){
        mCallBack = callBack;
    }


    //界面移出屏幕时接口回调
    public interface  Callback{
        void onFinish();
    }
}
