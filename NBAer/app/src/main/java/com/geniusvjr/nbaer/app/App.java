package com.geniusvjr.nbaer.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import im.fir.sdk.FIR;

/**
 * Created by dream on 16/5/10.
 */
public class App extends Application{

    private static Context sContext;
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        FIR.init(this);
        mRefWatcher = LeakCanary.install(this);
        sContext = getApplicationContext();
        AppService.getInstance().initService();
    }

    public static Context getContext(){
        return sContext;
    }
}
