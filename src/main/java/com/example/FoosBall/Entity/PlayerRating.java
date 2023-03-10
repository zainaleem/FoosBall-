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

    @Column(name="fore_hand_skill")
    @Convert(converter= PlayerSkillConverter.class)
    private PlayerSkill foreHandSkill;

    @Column(name="back_hand_skill")
    @Convert(converter=PlayerSkillConverter.class)
    private PlayerSkill backHandSkill;

    @OneToOne(mappedBy = "playerRating",orphanRemoval = true)
    @JsonIgnore
    private Player player;


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
