package com.geniusvjr.nbaer.model;

import java.util.List;

/**
 * 赛程
 * Created by dream on 16/4/23.
 */
public class Games {

    /**
     * status :
     * stateUrl :
     * rightTeam :
     * statusText :
     * statusUrl :
     * leftTeam :
     * rightScore :
     * stateText :
     * date : 12-26
     * type : 0
     */
    private List<GamesEntity> games;

    public List<GamesEntity> getGames() {
        return games;
    }

    public void setGames(List<GamesEntity> games) {
        this.games = games;
    }

    public static class GamesEntity
    {
        private String status;
        private String stateUrl;
        private String rightTeam;
        private String statusText;
        private String statusUrl;
        private String leftTeam;
        private String leftScore;
        private String rightScore;
        private String stateText;
        private String date;
        private int type;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStateUrl() {
            return stateUrl;
        }

        public void setStateUrl(String stateUrl) {
            this.stateUrl = stateUrl;
        }

        public String getRightTeam() {
            return rightTeam;
        }

        public void setRightTeam(String rightTeam) {
            this.rightTeam = rightTeam;
        }

        public String getStatusText() {
            return statusText;
        }

        public void setStatusText(String statusText) {
            this.statusText = statusText;
        }

        public String getStatusUrl() {
            return statusUrl;
        }

        public void setStatusUrl(String statusUrl) {
            this.statusUrl = statusUrl;
        }

        public String getLeftTeam() {
            return leftTeam;
        }

        public void setLeftTeam(String leftTeam) {
            this.leftTeam = leftTeam;
        }

        public String getLeftScore() {
            return leftScore;
        }

        public void setLeftScore(String leftScore) {
            this.leftScore = leftScore;
        }

        public String getRightScore() {
            return rightScore;
        }

        public void setRightScore(String rightScore) {
            this.rightScore = rightScore;
        }

        public String getStateText() {
            return stateText;
        }

        public void setStateText(String stateText) {
            this.stateText = stateText;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
