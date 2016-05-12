package com.geniusvjr.nbaer.event;


import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.model.Games;

/**
 * Created by SilenceDut on 2015/12/26.
 */
public class GamesEvent extends Event {
    private Games mAllGames;
    public GamesEvent(Games games, Constant.Result result) {
        this.mAllGames=games;
        this.mEventResult=result;
    }

    public Games getAllGames() {
        return mAllGames;
    }
}
