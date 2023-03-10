package com.example.FoosBall.Service;

import com.example.FoosBall.Adapter.PlayerAdapter;
import com.example.FoosBall.Adapter.TeamAdapter;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Exception.RecordNotFoundException;
import com.example.FoosBall.Repository.PlayerRepository;
import com.example.FoosBall.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TeamServiceImpl implements Service<TeamDto>{

    @Autowired
    TeamRepository teamRepo;

    @Autowired
    PlayerRepository playerRepository;
    @Override
    public List<TeamDto> findAll() {
        TeamAdapter teamAdapter = new TeamAdapter();
        List<Team> teamList = teamRepo.findAll();
        List<TeamDto> teamDtoList = new ArrayList<>();
        for (Team team:teamList) {
            teamDtoList.add(teamAdapter.convertDaoToDto(team));
        }
        return teamDtoList;
    }

//    public List<TeamDto> findByName() {
//        TeamAdapter teamAdapter = new TeamAdapter();
//        List<Team> teamList = teamRepo.findAll();
//        List<TeamDto> teamDtoList = new ArrayList<>();
//        for (Team team:teamList) {
//            teamDtoList.add(teamAdapter.convertDaoToDto(team));
//        }
//        return teamDtoList;
//    }

    @Override
    public TeamDto add(TeamDto dto) throws NameException {
        TeamAdapter teamAdapter = new TeamAdapter();
        if ( null != dto.getName() ) {
            if (!dto.getName().matches("^[a-zA-Z\\s]+")) {
                throw new NameException("Only alphabets and spaces are allowed for student's name.");
            }
        }
        Team team = teamRepo.save(teamAdapter.convertDtoToDao(dto));
        return teamAdapter.convertDaoToDto(team);
    }

    @Override
    public void deleteUsingId(Long id) {
        Optional<Team> teamOptional = teamRepo.findById(id);
        if(teamOptional.isPresent()){
            teamRepo.delete(teamOptional.get());
        }
        else {
            throw new RecordNotFoundException("Team not found");
        }
    }

    @Override
    public void deleteUsingName(String name) {
        Team team = teamRepo.findByName(name);
        if(team != null){
            teamRepo.delete(team);
        }
        else {
            throw new RecordNotFoundException("Player not found");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class) //ye laga diye ab ye khud save karey ga
    public TeamDto update(Long id, TeamDto dto) {
        TeamAdapter teamAdapter = new TeamAdapter();
        Team updateTeam = null;
        Optional<Team> teamOptional = teamRepo.findById(dto.getId());

        if(teamOptional.isPresent()) {
            updateTeam = teamAdapter.convertDtoToDaoUpdate(dto,teamOptional.get());
            //studentRepo.save(updateStudents);
        }
        return teamAdapter.convertDaoToDto(updateTeam);
    }

    @Override
    public TeamDto patch(Long id, TeamDto dto) {
        TeamAdapter teamAdapter = new TeamAdapter();
        Team patchTeam = null;
        Optional<Team> teamOptional = teamRepo.findById(dto.getId());
        //.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        if(teamOptional.isPresent()){
            patchTeam = teamAdapter.convertDtoToDaoPatch(dto,teamOptional.get());
            teamRepo.save(patchTeam);
        }
        return teamAdapter.convertDaoToDto(patchTeam);
    }

    public TeamDto updateTeamWithPlayer(TeamDto teamDto) throws RecordNotFoundException{
        PlayerAdapter playerAdapter = new PlayerAdapter();
        TeamAdapter teamAdapter = new TeamAdapter();
        List<Player> playerList = new ArrayList<>();

        teamDto.getPlayerDtoList().forEach(playerDto -> {
            Optional<Player> playerOptional = playerRepository.findByName(playerDto.getName());
            if(playerOptional.isPresent()){
            playerList.add(playerOptional.get());}
            else{
                throw new RecordNotFoundException("Player not found");
            }
        });

        Team team = teamRepo.findByName(teamAdapter.convertDtoToDao(teamDto).getName());
        playerList.forEach(player -> {
            player.setTeam(team);
            team.addPlayer(player);
        });

        teamRepo.save(team);
        return teamAdapter.convertDaoToDto(team);
    }


}
