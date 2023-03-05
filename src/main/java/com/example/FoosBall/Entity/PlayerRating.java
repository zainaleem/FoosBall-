package com.example.FoosBall.Entity;

import com.example.FoosBall.Enum.PlayerSkill;

import javax.persistence.*;

@Entity(name = "player_rating")
public class PlayerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_rating_id")
    private Long id;


    @Column(name="fore_hand_skill")
    private PlayerSkill foreHandSkill;


    @Column(name="back_hand_skill")
    private PlayerSkill backHandSkill;

    @OneToOne
    private Player player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerSkill getforeHandSkill() {
        return foreHandSkill;
    }

    public void setforeHandSkill(PlayerSkill foreHandSkill) {
        this.foreHandSkill = foreHandSkill;
    }

    public PlayerSkill getbackHandSkill() {
        return backHandSkill;
    }

    public void setbackHandSkill(PlayerSkill backHandSkill) {
        this.backHandSkill = backHandSkill;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
