package com.example.FoosBall.Entity;

import com.example.FoosBall.Enum.PlayerSkill;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_age")
    private int age;

    @OneToOne
    @JoinColumn(name = "player_rating_id")
    @Enumerated(EnumType.STRING)
    private PlayerRating playerSkill;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "team_id")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerRating getPlayerSkill() {
        return playerSkill;
    }

    public void setPlayerSkill(PlayerRating playerSkill) {
        this.playerSkill = playerSkill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
