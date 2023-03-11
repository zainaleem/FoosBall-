package com.example.FoosBall.Service;

import com.example.FoosBall.Adapter.PlayerAdapter;
import com.example.FoosBall.Adapter.TeamAdapter;
import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Player;
//import com.example.FoosBall.Entity.PlayerRating;
import com.example.FoosBall.Entity.PlayerDetails;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Enum.PlayerSkill;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Exception.RecordNotFoundException;
import com.example.FoosBall.Repository.PlayerDetailsRepo;
import com.example.FoosBall.Repository.PlayerRepository;
import com.example.FoosBall.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class PlayerServiceImpl implements Service<PlayerDto>{

    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    TeamRepository teamRepo;

    @Autowired
    PlayerDetailsRepo playerDetailsRepo;

    public List<PlayerDto> findAll(){
        PlayerAdapter playerAdapter = new PlayerAdapter();
        List<Player> playerList = playerRepo.findAll();
        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player player:playerList) {
            playerDtoList.add(playerAdapter.convertDaoToDto(player));
        }
        return playerDtoList;
    }

    public List<String> findAllPlayerNames(){
    List<String> playerNames= playerRepo.findAllNames();
    return playerNames;
    }

    public PlayerDto findByPlayerName(String name) throws RecordNotFoundException {
        PlayerAdapter playerAdapter=new PlayerAdapter();
        Optional<Player> playerOptional = playerRepo.findByName(name);
        Player player = null;
        if(playerOptional.isPresent()){
            player = playerOptional.get();
        }
        else {
            throw new RecordNotFoundException("Player not found. Try with space between name");
        }

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
//        Team team = null;
//        Optional<Team> teamOptional = teamRepo.findById(dto.getTeamDto().getId());
//        if(teamOptional.isPresent()){
//            team = teamOptional.get();
//        }
        //Player player = playerRepo.save(playerAdapter.convertDtoToDao(dto,team));
        Player player = playerRepo.save(playerAdapter.convertDtoToDao(dto));
        return playerAdapter.convertDaoToDto(player);
    }

    @Override
    public void deleteUsingId(Long id) throws RecordNotFoundException{
        Optional<Player> playerOptional = playerRepo.findById(id);
        if(playerOptional.isPresent()){
            playerRepo.delete(playerOptional.get());
        }
        else {
            throw new RecordNotFoundException("Player not found");
        }
    }

    @Override
    public void deleteUsingName(String name) throws RecordNotFoundException {

        Optional<Player> playerOptional = playerRepo.findByName(name);
        if(playerOptional.isPresent()){
            playerRepo.delete(playerOptional.get());
        }
        else {
            throw new RecordNotFoundException("Player not found");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class) //ye laga diye ab ye khud save karey ga
    public PlayerDto update(Long id, PlayerDto dto) {
        PlayerAdapter playerAdapter = new PlayerAdapter();
        Player updatePlayer = null;
        Optional<Player> playerOptional = playerRepo.findById(dto.getId());

        if(playerOptional.isPresent()) {
            updatePlayer = playerAdapter.convertDtoToDaoUpdate(dto,playerOptional.get());
            //studentRepo.save(updateStudents);
        }
        return playerAdapter.convertDaoToDto(updatePlayer);
    }

    @Override
    public PlayerDto patch(Long id, PlayerDto dto) {
        PlayerAdapter playerAdapter = new PlayerAdapter();
        Player patchPlayer = null;
        Optional<Player> playerOptional  = playerRepo.findById(dto.getId());
        //.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        if(playerOptional.isPresent()){
            patchPlayer = playerAdapter.convertDtoToDaoPatch(dto,playerOptional.get());
            playerRepo.save(patchPlayer);
        }
        return playerAdapter.convertDaoToDto(patchPlayer);
    }

    public PlayerDto updatePlayerDetails(PlayerDto playerDto){
        PlayerAdapter playerAdapter = new PlayerAdapter();
        Optional<Player> playerOptional = playerRepo.findByName(playerDto.getName());
        Player player=null;
        if(playerOptional.isPresent()){
            player = playerOptional.get();
        }
        PlayerDetails playerDetails = playerDetailsRepo.findByPlayerName(playerDto.getPlayerDetailsDto().getPlayerName());
        player.setPlayerDetails(playerDetails);
        playerRepo.save(player);
        return playerAdapter.convertDaoToDto(player);
    }
}
