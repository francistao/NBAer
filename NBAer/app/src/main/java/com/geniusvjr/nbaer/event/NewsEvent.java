package com.geniusvjr.nbaer.event;


import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.model.News;

/**
 * Created by Silencedut on 2015/11/28.
 */
public class NewsEvent extends Event {

    private News news;
    private Constant.GETNEWSWAY getNewsWay;
    private String newsType;

    public String getNewsType() {
        return newsType;
    }

    public NewsEvent(News news, Constant.GETNEWSWAY getNewsWay, String newsType) {
        this.news=news;
        this.newsType=newsType;
        this.getNewsWay=getNewsWay;

    }

    public News getNews() {
        return news;
    }

    public Constant.GETNEWSWAY getNewsWay() {
        return getNewsWay;
    }
}
