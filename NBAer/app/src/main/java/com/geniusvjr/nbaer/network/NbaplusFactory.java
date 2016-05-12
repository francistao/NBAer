package com.geniusvjr.nbaer.network;

import com.geniusvjr.nbaer.model.NewsDetile;

/**
 * Created by dream on 16/5/10.
 */
public class NbaplusFactory {

    private static NbaplusAPI sInstanceInstance = null;
    private static NewsDetileAPI sNewsSetileInStance = null;
    private static final Object WATCH_DOG = new Object();

    public NbaplusFactory() {

    }

    public static NbaplusAPI getNbaplusInstance(){
        synchronized (WATCH_DOG){
            if(sInstanceInstance == null){
                NbaplusClient nbaplusClient = new NbaplusClient();
                sInstanceInstance = nbaplusClient.getClient();
                sNewsSetileInStance = nbaplusClient.getNewsDetileClient();
            }
            return  sInstanceInstance;
        }
    }

    public static NewsDetileAPI getNewsDetileInstance(){
        synchronized (WATCH_DOG){
            if(sNewsSetileInStance == null){
                NbaplusClient nbaplusClient = new NbaplusClient();
                sInstanceInstance = nbaplusClient.getClient();
                sNewsSetileInStance = nbaplusClient.getNewsDetileClient();
            }
            return sNewsSetileInStance;
        }
    }




}
