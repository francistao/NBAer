package com.geniusvjr.nbaer.network;


import com.geniusvjr.nbaer.model.NewsDetile;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by SilenceDut on 2015/12/10.
 */
public interface NewsDetileAPI {
    @GET("{date}/{detileId}")
    Observable<NewsDetile> getNewsDetile(@Path("date") String type, @Path("detileId") String newsId);
}
