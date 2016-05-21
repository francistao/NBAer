package com.geniusvjr.nbaer.rxmethod;

import com.geniusvjr.nbaer.app.AppService;
import com.geniusvjr.nbaer.model.Statistics;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by dream on 16/5/13.
 */
public class RxStats {
    public static Subscription getPerStat(String ...statKinds){

        Subscription subscription = Observable.from(statKinds)
                .flatMap(new Func1<String, Observable<Statistics>>() {
                    @Override
                    public Observable<Statistics> call(String s) {
                        return AppService.getNbaplus().getPerStats(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnNext(new Action1<Statistics>() {
                    @Override
                    public void call(Statistics statistics) {

                    }
                })
                .subscribe(new Action1<Statistics>() {
                    @Override
                    public void call(Statistics statistics) {

                    }
                });
        return subscription;
    }

    public static Subscription initStat(final String statKind){

        Subscription subscription = Observable.create(new Observable.OnSubscribe<Statistics>(){

            @Override
            public void call(Subscriber<? super Statistics> subscriber) {

            }
        }).subscribeOn(Schedulers.io())
                .subscribe(new Action1<Statistics>() {
                    @Override
                    public void call(Statistics statistics) {

                    }
                });
        return subscription;
    }

    private static String[][] getLables(Statistics statistics){
        String[][] players = new String[2][5];
        for (int index = 0; index < 5; index++){
//            players[0][index] =
        }
        return players;
    }

//    private static String parseLable(Statistics.StatEntity statEntity){
//        StringBuilder lable = new StringBuilder();
//        String playerName = statEntity.getName();
//
//    }





}
