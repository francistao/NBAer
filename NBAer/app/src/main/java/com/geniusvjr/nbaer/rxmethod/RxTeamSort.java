package com.geniusvjr.nbaer.rxmethod;


import com.geniusvjr.nbaer.app.AppService;
import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.event.TeamSortEvent;
import com.geniusvjr.nbaer.model.Teams;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by SlienceDut on 2015/12/23.
 */
public class RxTeamSort {
    public static Subscription getTeams() {
        Subscription subscription = AppService.getNbaplus().getTeamSort()
                .subscribeOn(Schedulers.io())
                .doOnNext(new Action1<Teams>() {
                    @Override
                    public void call(Teams teams) {
                        cacheTeams();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Teams>() {
                    @Override
                    public void call(Teams news) {
                        AppService.getBus().post(new TeamSortEvent(news, Constant.Result.SUCCESS));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        AppService.getBus().post(new TeamSortEvent(null, Constant.Result.FAIL));
                    }
                });
        return subscription;
    }

    private static void cacheTeams() {

    }
}

