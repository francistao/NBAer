package com.geniusvjr.nbaer.model;

import java.util.List;

/**
 * Created by dream on 16/4/23.
 */
public class Statistics {

    /**
     * place : 1
     * statkind : points
     * name : 杰里米-林
     * statdata : 35
     * team : 黄蜂
     */
    private List<StatEntity> dailyStat;

    /**
     * place : 1
     * statkind : points
     * name : 斯蒂芬-库里
     * statdata : 32
     * team : 勇士
     */
    private List<StatEntity> everageStat;

    public List<StatEntity> getDailyStat() {
        return dailyStat;
    }

    public void setDailyStat(List<StatEntity> dailyStat) {
        this.dailyStat = dailyStat;
    }

    public List<StatEntity> getEverageStat() {
        return everageStat;
    }

    public void setEverageStat(List<StatEntity> everageStat) {
        this.everageStat = everageStat;
    }

    public static class StatEntity
    {
        private String place;
        private String statkind;
        private String playerurl;
        private String name;
        private String statdata;
        private String team;

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getStatkind() {
            return statkind;
        }

        public void setStatkind(String statkind) {
            this.statkind = statkind;
        }

        public String getPlayerurl() {
            return playerurl;
        }

        public void setPlayerurl(String playerurl) {
            this.playerurl = playerurl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatdata() {
            return statdata;
        }

        public void setStatdata(String statdata) {
            this.statdata = statdata;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }
    }
}
