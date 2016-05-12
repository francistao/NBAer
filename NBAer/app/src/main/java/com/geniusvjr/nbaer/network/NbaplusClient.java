package com.geniusvjr.nbaer.network;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dream on 16/5/10.
 */
public class NbaplusClient {

    NbaplusAPI nbaplus;
    NewsDetileAPI newsDetileAPI;

    NbaplusClient() {
        Retrofit retrofit0 = new Retrofit.Builder()
                .baseUrl("http://nbaplus.sinaapp.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory .create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        nbaplus = retrofit0.create(NbaplusAPI.class);

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://reader.res.meizu.com/reader/articlecontent/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsDetileAPI = retrofit1.create(NewsDetileAPI.class);
    }

    public NbaplusAPI getClient(){
        return nbaplus;
    }


    public NewsDetileAPI getNewsDetileClient(){
        return newsDetileAPI;
    }
}
