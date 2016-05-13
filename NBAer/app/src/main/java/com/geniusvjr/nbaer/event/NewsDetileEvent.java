package com.geniusvjr.nbaer.event;

/**
 * Created by dream on 16/5/10.
 */
public class NewsDetileEvent extends Event{
    private String mNewsContent;

    public NewsDetileEvent(String mNewsContent) {
        this.mNewsContent = mNewsContent;
    }

    public String getContent(){
        return mNewsContent;
    }
}
