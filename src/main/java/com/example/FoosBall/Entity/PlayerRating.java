package com.example.FoosBall.Entity;

import com.example.FoosBall.Enum.PlayerSkill;
import com.example.FoosBall.EnumConverter.PlayerSkillConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "player_rating")
public class PlayerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_rating_id")
    private Long id;

    @Convert(converter= PlayerSkillConverter.class)
    private PlayerSkill foreHandSkill;

    @Convert(converter=PlayerSkillConverter.class)
    private PlayerSkill backHandSkill;

    @Column
    private Float matchesWon;
    @Column
    private Float totalMatches;

    @Column
    private Float winPercentage;

    @OneToOne(mappedBy = "playerRating",orphanRemoval = true)
    @JsonIgnore
    private Player player;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
