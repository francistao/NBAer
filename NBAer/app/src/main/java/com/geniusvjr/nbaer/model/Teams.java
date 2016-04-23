package com.geniusvjr.nbaer.model;

import java.util.List;

/**
 * 排名
 * Created by dream on 16/4/23.
 */
public class Teams {

    /**
     * sort : 排名
     * winPercent : 胜率
     * win : 胜
     * lose : 负
     * gap : 胜差
     * team : 球队
     */

    private List<TeamsortEntity> teamsort;

    public List<TeamsortEntity> getTeamsort() {
        return teamsort;
    }

    public void setTeamsort(List<TeamsortEntity> teamsort) {
        this.teamsort = teamsort;
    }

    public static class TeamsortEntity
    {
        private String teamurl;
        private String sort;
        private String winPercent;
        private String win;
        private String lose;
        private String gap;
        private String team;

        public String getTeamurl() {
            return teamurl;
        }

        public void setTeamurl(String teamurl) {
            this.teamurl = teamurl;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getWinPercent() {
            return winPercent;
        }

        public void setWinPercent(String winPercent) {
            this.winPercent = winPercent;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
        }

        public String getLose() {
            return lose;
        }

        public void setLose(String lose) {
            this.lose = lose;
        }

        public String getGap() {
            return gap;
        }

        public void setGap(String gap) {
            this.gap = gap;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }
    }
}
