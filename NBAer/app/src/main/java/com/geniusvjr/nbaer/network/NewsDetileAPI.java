package com.geniusvjr.nbaer.network;

import com.geniusvjr.nbaer.model.NewsDetile;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dream on 16/4/23.
 */
public interface NewsDetileAPI {

    @GET("{date}/{detailId}")
    Observable<NewsDetile> getNewsDetail(@Path("data") String type,@Path("detileId") String newsId);

}
