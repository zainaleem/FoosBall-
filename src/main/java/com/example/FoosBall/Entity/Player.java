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
    private Integer age;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "player_rating_id")
//    //@Enumerated(EnumType.STRING)
//    private PlayerRating playerRating;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

//    public PlayerRating getPlayerRating() {
//        return playerRating;
//    }
//
//    public void setPlayerRating(PlayerRating playerRating) {
//        this.playerRating = playerRating;
//    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
