package com.example.FoosBall.Service;

import com.example.FoosBall.Adapter.PlayerAdapter;
import com.example.FoosBall.Adapter.TeamAdapter;
import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Repository.PlayerRepository;
import com.example.FoosBall.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class PlayerServiceImpl implements Service<PlayerDto>{

    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    TeamRepository teamRepo;

    public List<PlayerDto> findAll(){
        PlayerAdapter playerAdapter = new PlayerAdapter();
        List<Player> playerList = playerRepo.findAll();
        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player player:playerList) {
            playerDtoList.add(playerAdapter.convertDaoToDto(player));
        }
        return playerDtoList;
    }

    public PlayerDto findByPlayerName(String name) {
        PlayerAdapter playerAdapter=new PlayerAdapter();
        Player player = playerRepo.findByName(name);
        return playerAdapter.convertDaoToDto(player);
    }

    public List<PlayerDto> findByTeamName(String teamName){
        PlayerAdapter playerAdapter = new PlayerAdapter();
        List<Player> playerList = playerRepo.findByTeamName(teamName);
        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player player:playerList) {
            playerDtoList.add(playerAdapter.convertDaoToDto(player));
        }
        return playerDtoList;
    }
    @Override
    public PlayerDto add(PlayerDto dto) throws NameException {
        PlayerAdapter playerAdapter = new PlayerAdapter();
        if ( null != dto.getName() ) {
            if (!dto.getName().matches("^[a-zA-Z\\s]+")) {
                throw new NameException("Only alphabets and spaces are allowed for student's name.");
            }
        }
        Team team = null;
        Optional<Team> teamOptional = teamRepo.findById(dto.getTeamDto().getId());
        if(teamOptional.isPresent()){
            team = teamOptional.get();
        }
        Player player = playerRepo.save(playerAdapter.convertDtoToDao(dto,team));
        return playerAdapter.convertDaoToDto(player);
    }

    @Override
    public void deleteUsingId(Long id) {
        playerRepo.deleteById(id);
    }

    @Override
    public PlayerDto update(Long id, PlayerDto dto) {
        return null;
    }



}
