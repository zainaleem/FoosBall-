package com.example.FoosBall.Dtos;

//import com.example.FoosBall.Entity.PlayerRating;
import com.example.FoosBall.Enum.PlayerSkill;

public class PlayerDto {

    private Long id;

    private String name;

    private Integer age;

    //private PlayerRatingDto playerRatingDto;

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

//    public PlayerRatingDto getPlayerRatingDto() {
//        return playerRatingDto;
//    }
//
//    public void setPlayerRatingDto(PlayerRatingDto playerRatingDto) {
//        this.playerRatingDto = playerRatingDto;
//    }

    public TeamDto getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.teamDto = teamDto;
    }


}
