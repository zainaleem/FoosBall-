package com.example.FoosBall.Dtos;

import com.example.FoosBall.Enum.PlayerSkill;

public class PlayerRatingDto {

    private Long id;

    private PlayerSkill foreHandSkill;

    private PlayerSkill backHandSkill;
    private Float matchesWon;
    private Float totalMatches;
    private Float winPercentage;
    private PlayerDto playerDto;

    //private PlayerSkill playerSkill;

    public Float getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(Float matchesWon) {
        this.matchesWon = matchesWon;
    }

    public Float getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Float totalMatches) {
        this.totalMatches = totalMatches;
    }

    public Float getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(Float winPercentage) {
        this.winPercentage = winPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerSkill getForeHandSkill() {
        return foreHandSkill;
    }

    public void setForeHandSkill(PlayerSkill foreHandSkill) {
        this.foreHandSkill = foreHandSkill;
    }

    public PlayerSkill getBackHandSkill() {
        return backHandSkill;
    }

    public void setBackHandSkill(PlayerSkill backHandSkill) {
        this.backHandSkill = backHandSkill;
    }

    public PlayerDto getPlayerDto() {
        return playerDto;
    }

    public void setPlayerDto(PlayerDto playerDto) {
        this.playerDto = playerDto;
    }
}
