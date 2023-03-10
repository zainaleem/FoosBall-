package com.example.FoosBall.Dtos;

import com.example.FoosBall.Entity.PlayerRating;

public class PlayerDto {

    private Long id;

    private String name;

    private Integer age;

    private PlayerRating playerRating;

    private TeamDto teamDto;

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

    public PlayerRating getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(PlayerRating playerRating) {
        this.playerRating = playerRating;
    }

    public TeamDto getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.teamDto = teamDto;
    }


}
