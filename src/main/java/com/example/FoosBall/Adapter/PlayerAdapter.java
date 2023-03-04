package com.example.FoosBall.Adapter;

import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlayerAdapter implements Adapter<PlayerDto, Player>{
    @Autowired
    TeamRepository teamRepo;
    public Player convertDtoToDao(PlayerDto playerDto,Team team) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        player.setPlayerSkill(playerDto.getPlayerSkill());
        player.setTeam(team);
        return player;
    }

    @Override
    public Player convertDtoToDao(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        player.setPlayerSkill(playerDto.getPlayerSkill());
        return player;
    }

    @Override
    public PlayerDto convertDaoToDto(Player player) {
        PlayerDto playerDto = new PlayerDto();
        TeamAdapter teamAdapter = new TeamAdapter();
        TeamDto teamDto = teamAdapter.convertDaoToDto(player.getTeam());
        playerDto.setName(player.getName());
        playerDto.setAge(player.getAge());
        playerDto.setPlayerSkill(player.getPlayerSkill());
        playerDto.setId(player.getId());
        playerDto.setTeamDto(teamDto);
        return playerDto;
    }
}
