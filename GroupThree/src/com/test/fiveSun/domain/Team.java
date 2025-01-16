package com.test.fiveSun.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {
    private String name;                // 팀 이름
    private LocalDate foundationDate;   // 창단일
    private String homeCity;            // 연고지
    private String homeStadium;         // 홈구장
    private int championshipWins;       // 우승 횟수
    private String coach;               // 감독 이름
    private Map<Long, Player> players;  // 선수 목록

    public Team(String name, LocalDate foundationDate, String homeCity, String homeStadium, int championshipWins, String coach) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.homeCity = homeCity;
        this.homeStadium = homeStadium;
        this.championshipWins = championshipWins;
        this.coach = coach;
        this.players = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public String getHomeStadium() {
        return homeStadium;
    }

    public int getChampionshipWins() {
        return championshipWins;
    }

    public String getCoach() {
        return coach;
    }

    public Map<Long, Player> getPlayers() {
        return players;
    }

}
