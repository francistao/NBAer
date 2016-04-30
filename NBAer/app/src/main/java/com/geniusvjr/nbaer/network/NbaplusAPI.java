package com.geniusvjr.nbaer.network;

import com.geniusvjr.nbaer.model.Games;
import com.geniusvjr.nbaer.model.News;
import com.geniusvjr.nbaer.model.Statistics;
import com.geniusvjr.nbaer.model.Teams;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dream on 16/4/23.
 */
public interface NbaplusAPI {

    @GET("api/v1.0/{type}/update")
    Observable<News> updateNews(@Path("type") String type);
    @GET("api/v1.0/{type}/loadmore/{newsId}")
    Observable<News> loadMoreNews(@Path("type") String type, @Path("newsId") String newsId);
    @GET("api/v1.0/nbastat/perstat/{statKind}")
    Observable<Statistics> getPerStats(@Path("statKind") String statKind);
    @GET("api/v1.0/teamsort/sort")
    Observable<Teams> getTeamSort();
    @GET("api/v1.0/gamesdate/{date}")
    Observable<Games> getGames(@Path("date") String date);
}
