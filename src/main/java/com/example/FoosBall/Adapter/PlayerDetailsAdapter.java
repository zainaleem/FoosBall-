package com.example.FoosBall.Adapter;

import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Entity.PlayerDetails;

public class PlayerDetailsAdapter implements Adapter<PlayerDetailsDto, PlayerDetails>{

    @Override
    public PlayerDetails convertDtoToDao(PlayerDetailsDto playerDetailsDto) {
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setPlayerName(playerDetailsDto.getPlayerName());
        playerDetails.setEmail(playerDetailsDto.getEmail());
        playerDetails.setCellNumber(playerDetailsDto.getCellNumber());
        return playerDetails;
    }

    @Override
    public PlayerDetailsDto convertDaoToDto(PlayerDetails playerDetails) {
        PlayerDetailsDto playerDetailsDto = new PlayerDetailsDto();
        playerDetailsDto.setPlayerName(playerDetails.getPlayerName());
        playerDetailsDto.setEmail(playerDetails.getEmail());
        playerDetailsDto.setCellNumber(playerDetails.getCellNumber());
        playerDetailsDto.setId(playerDetails.getId());
        return playerDetailsDto;
    }
}
