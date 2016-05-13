package com.geniusvjr.nbaer.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * 数值的工具类
 * Created by dream on 16/5/5.
 */
public class NumericalUtil {

    private static int screenWidth = 0;
    private static int screenHeight = 0;


    //将dp转换为px
    public static int dp2px(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    //获取屏幕高度
    public static int getScreenHeight(Context c){
        if(screenHeight == 0){
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }
        return screenHeight;
    }


    //获得屏幕的宽度
    public static int getScreenWidth(Context c){
        if(screenWidth == 0){
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }
        return screenWidth;
    }

    public static boolean isAndroid5(){
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP;
    }

}
