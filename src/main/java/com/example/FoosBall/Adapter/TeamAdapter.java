package com.example.FoosBall.Adapter;

import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Team;

public class TeamAdapter implements Adapter<TeamDto, Team>{
    @Override
    public Team convertDtoToDao(TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        return team;
    }

    @Override
    public TeamDto convertDaoToDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setName(team.getName());
        teamDto.setId(team.getId());

        return teamDto;
    }
    public Team convertDtoToDaoUpdate(TeamDto teamDto, Team team) {
        team.setName(teamDto.getName());
        return team;
    }
    public Team convertDtoToDaoPatch(TeamDto teamDto, Team team) {
        if (teamDto.getName() != null) {
            team.setName(teamDto.getName());
        }
        return team;
    }
}
