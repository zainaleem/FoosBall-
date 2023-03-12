package com.example.FoosBall.Dtos;

import com.example.FoosBall.Entity.Player;

import java.util.List;

public class TeamDto {
    private Long id;

    private String name;

    private List<Player> players;

//    public List<PlayerDto> getPlayerDtoList() {
//        return playerDtoList;
//    }
//
//    public void setPlayerDtoList(List<PlayerDto> playerDtoList) {
//        this.playerDtoList = playerDtoList;
//    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
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
}
