package com.geniusvjr.nbaer.event;

import com.geniusvjr.nbaer.data.Constant;

/**
 * Created by SilenceDut on 2015/11/28.
 */
public class Event {
    protected Constant.Result mEventResult;

    public void setEventResult(Constant.Result eventResult) {
        this.mEventResult=eventResult;
    }

    public Constant.Result getEventResult() {
        return mEventResult;
    }
}
