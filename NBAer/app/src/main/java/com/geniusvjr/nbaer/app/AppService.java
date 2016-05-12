package com.geniusvjr.nbaer.app;


import android.os.Handler;
import android.os.HandlerThread;

import com.geniusvjr.greendao.DBHelper;
import com.geniusvjr.nbaer.network.NbaplusAPI;
import com.geniusvjr.nbaer.network.NbaplusFactory;
import com.geniusvjr.nbaer.network.NewsDetileAPI;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import de.greenrobot.event.EventBus;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by SilenceDut on 2015/11/28.
 */
public class AppService {
    private static final AppService NBAPLUS_SERVICE=new AppService();
    private static Gson sGson;
    private static EventBus sBus ;
    private static DBHelper sDBHelper;
    private static NbaplusAPI sNbaplusApi;
    private static NewsDetileAPI sNewsDetileApi;
    private static ExecutorService sSingleThreadExecutor;
    private Map<Integer,CompositeSubscription> mCompositeSubByTaskId;
    private Handler mIoHandler;

    private AppService(){}

    public void initService() {
        sBus = EventBus.getDefault();
        sGson=new Gson();
        mCompositeSubByTaskId=new HashMap<Integer,CompositeSubscription>();
        //sSingleThreadExecutor= Executors.newSingleThreadExecutor();
        backGroundInit();
    }

    private void backGroundInit() {
        HandlerThread ioThread = new HandlerThread("IoThread");
        ioThread.start();
        mIoHandler= new Handler(ioThread.getLooper());
        mIoHandler.post(new Runnable() {
            @Override
            public void run() {
                sNbaplusApi = NbaplusFactory.getNbaplusInstance();
                sNewsDetileApi = NbaplusFactory.getNewsDetileInstance();
                sDBHelper = DBHelper.getInstance(App.getContext());
            }
        });

    }

    public void addCompositeSub(int taskId) {
        CompositeSubscription compositeSubscription;
        if(mCompositeSubByTaskId.get(taskId)==null) {
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

    private CompositeSubscription getCompositeSubscription(int taskId) {
        CompositeSubscription compositeSubscription ;
        if(mCompositeSubByTaskId.get(taskId)==null) {
            compositeSubscription = new CompositeSubscription();
            mCompositeSubByTaskId.put(taskId, compositeSubscription);
        }else {
            compositeSubscription= mCompositeSubByTaskId.get(taskId);
        }
        return compositeSubscription;
    }


//    public void initNews(int taskId,String type) {
//        getCompositeSubscription(taskId).add(RxNews.initNews(type));
//    }
//
//    public void updateNews(int taskId,String type) {
//        getCompositeSubscription(taskId).add(RxNews.updateNews(type));
//    }
//
//    public void loadMoreNews(int taskId,String type,String newsId) {
//        getCompositeSubscription(taskId).add(RxNews.loadMoreNews(type, newsId));
//    }
//
//    public void getNewsDetile(int taskId,String date,String detielId) {
//        getCompositeSubscription(taskId).add(RxNews.getNewsDetile(date, detielId));
//    }
//
//    public void initPerStat(int taskId,String  statKind) {
//        getCompositeSubscription(taskId).add(RxStats.initStat(statKind));
//    }
//
//    public void getPerStat(int taskId,String ...statKinds) {
//        getCompositeSubscription(taskId).add(RxStats.getPerStat(statKinds));
//    }
//
//    public void getTeamSort(int taskId) {
//        getCompositeSubscription(taskId).add(RxTeamSort.getTeams());
//    }
//
//    public void getGames(int taskId,String date) {
//        getCompositeSubscription(taskId).add(RxGames.getTeams(date));
//    }


    public static AppService getInstance() {
        return NBAPLUS_SERVICE;
    }

    public static EventBus getBus() {
        return sBus;
    }

    public static NbaplusAPI getNbaplus() {
        return sNbaplusApi;
    }

    public static NewsDetileAPI getNewsDetileApi() {
        return sNewsDetileApi;
    }

    public static DBHelper getDBHelper() {
        return sDBHelper;
    }

    public static Gson getGson() {
        return sGson;
    }

    public static ExecutorService getSingleThreadExecutor(){
        return sSingleThreadExecutor;
    }

}
