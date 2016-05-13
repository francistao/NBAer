package com.geniusvjr.nbaer.rxmethod;

import com.geniusvjr.nbaer.app.AppService;
import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.event.GamesEvent;
import com.geniusvjr.nbaer.model.Games;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by dream on 16/5/12.
 */
public class RxGames {

    public static Subscription getTeams(String date){

        Subscription subscription = AppService.getNbaplus().getGames(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Games>() {
                    @Override
                    public void call(Games games) {
                        AppService.getBus().post(new GamesEvent(games, Constant.Result.SUCCESS));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        AppService.getBus().post(new GamesEvent(null, Constant.Result.FAIL));
                    }
                });
        return subscription;
    }
}
