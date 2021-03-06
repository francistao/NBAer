package com.geniusvjr.nbaer.network;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SilenceDut on 2015/11/28.
 */
public class NbaplusClient {
    final NbaplusAPI nbaplus ;
    final NewsDetileAPI newsDetileAPI;
    NbaplusClient() {
        Retrofit retrofit0 = new Retrofit.Builder()
                .baseUrl("http://nbaplus.sinaapp.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        nbaplus=retrofit0.create(NbaplusAPI.class);

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://reader.res.meizu.com/reader/articlecontent/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsDetileAPI=retrofit1.create(NewsDetileAPI.class);

    }

    public NbaplusAPI getCilent() {
        return nbaplus;
    }

    public NewsDetileAPI getNewsDetileClient() {
        return newsDetileAPI;
    }
}
