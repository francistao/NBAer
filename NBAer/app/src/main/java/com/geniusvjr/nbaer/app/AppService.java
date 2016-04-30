package com.geniusvjr.nbaer.app;

import android.os.Handler;
import android.os.HandlerThread;

import com.geniusvjr.greendao.DBHelper;
import com.geniusvjr.nbaer.network.NbaplusAPI;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import de.greenrobot.event.EventBus;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dream on 16/4/23.
 */
public class AppService {

    private static final AppService NBAPLUS_SERVICE = new AppService();
    private static Gson sGson;
    private static EventBus sBus;
    private static DBHelper sDBHelper;
    private static NbaplusAPI sNbaplusApi;
    private static ExecutorService sSingleThreadExecutor;

    private Map<Integer, CompositeSubscription> mCompositeSubByTaskId;
    private Handler mIoHandler;

    public static AppService getInstance()
    {
        return NBAPLUS_SERVICE;
    }

    public void initService()
    {
        sBus = EventBus.getDefault();
        sGson = new Gson();
        mCompositeSubByTaskId = new HashMap<Integer, CompositeSubscription>();
        backGroundInit();
    }

    private void backGroundInit() {
        HandlerThread ioThread = new HandlerThread("IoThread");
        ioThread.start();
        mIoHandler = new Handler(ioThread.getLooper());
        mIoHandler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void addCompositeSub(int taskId)
    {
        CompositeSubscription compositeSubscription;
        if(mCompositeSubByTaskId.get(taskId) == null)
        {
            compositeSubscription = new CompositeSubscription();
            mCompositeSubByTaskId.put(taskId, compositeSubscription);
        }
    }

    public void removeCompositeSub(int taskId) {
        CompositeSubscription compositeSubscription;
        if(mCompositeSubByTaskId!=null&& mCompositeSubByTaskId.get(taskId)!=null){
            compositeSubscription= mCompositeSubByTaskId.get(taskId);
            compositeSubscription.unsubscribe();
            mCompositeSubByTaskId.remove(taskId);
        }
    }
    public static EventBus getBus()
    {
        return sBus;
    }



}
