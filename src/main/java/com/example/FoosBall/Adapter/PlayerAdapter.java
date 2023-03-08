package com.example.FoosBall.Adapter;

import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Dtos.PlayerRatingDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Player;
//import com.example.FoosBall.Entity.PlayerRating;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlayerAdapter implements Adapter<PlayerDto, Player>{

    public Player convertDtoToDao(PlayerDto playerDto,Team team) {
        Player player = new Player();
//        PlayerRatingAdapterImpl playerRatingAdapter = new PlayerRatingAdapterImpl();
//        PlayerRating playerRating = playerRatingAdapter.convertDtoToDao(playerDto.getPlayerRatingDto());
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        //player.setPlayerRating(playerRating);
        //player.setPlayerSkill(playerDto.getPlayerSkill());
        player.setTeam(team);
        return player;
    }

    @Override
    public Player convertDtoToDao(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        return player;
    }

    @Override
    public PlayerDto convertDaoToDto(Player player) {
        PlayerDto playerDto = new PlayerDto();
        TeamAdapter teamAdapter = new TeamAdapter();
        TeamDto teamDto = teamAdapter.convertDaoToDto(player.getTeam());
//        PlayerRatingAdapterImpl playerRatingAdapter = new PlayerRatingAdapterImpl();
//        PlayerRatingDto playerRatingDto = playerRatingAdapter.convertDaoToDto(player.getPlayerRating());

        playerDto.setName(player.getName());
        playerDto.setAge(player.getAge());
        playerDto.setId(player.getId());
        //playerDto.setPlayerRatingDto(playerRatingDto);
        playerDto.setTeamDto(teamDto);
        return playerDto;
    }

    public Player convertDtoToDaoUpdate(PlayerDto playerDto, Player player) {
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        return player;
    }

    public Player convertDtoToDaoPatch(PlayerDto playerDto, Player player) {
        if (playerDto.getName() != null) {
            player.setName(playerDto.getName());
        } else if (playerDto.getAge()!= null) {
            player.setAge(playerDto.getAge());
        }

        return player;
    }
}
