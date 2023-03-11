package com.example.FoosBall.Controller;

import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Exception.RecordNotFoundException;
import com.example.FoosBall.Service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {
    @Autowired
    TeamServiceImpl teamService;

    @GetMapping("/team")
    public ResponseEntity<List<TeamDto>> getTeams() {
        return new ResponseEntity<>(teamService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<TeamDto>> getTeamByName() {
        return new ResponseEntity<>(teamService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/team")
    public ResponseEntity<List<TeamDto>> addTeam(@RequestBody TeamDto teamDto) {

        try{
            teamService.add(teamDto);
        }
        catch (NameException nameException){
            nameException.printStackTrace();
            nameException.getMessage();
        }

        finally {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @PutMapping("/team/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id,@RequestBody TeamDto teamDto)
    {
        TeamDto dto = teamService.update(id,teamDto);
        return new ResponseEntity<TeamDto>(dto,HttpStatus.OK);
    }

    @PutMapping("/team/player")
    public ResponseEntity<TeamDto> updateTeamWithPlayers(@RequestBody TeamDto teamDto)
    {
        try{
        TeamDto dto = teamService.updateTeamWithPlayer(teamDto);
        return new ResponseEntity<TeamDto>(dto,HttpStatus.OK);
    }
    catch (RecordNotFoundException recordNotFoundException){
        System.out.println(recordNotFoundException.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }


    @PatchMapping("/team/{id}")
    public TeamDto patchTeam(@PathVariable Long id, @RequestBody TeamDto teamDto) {
        return teamService.patch(id, teamDto);
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<TeamDto> deleteTeam(@PathVariable Long id){
        try{
        teamService.deleteUsingId(id);
        return new ResponseEntity<TeamDto>(HttpStatus.OK);
    }
        catch (RecordNotFoundException recordNotFoundException){
            System.out.println(recordNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/team/{name}")
    public ResponseEntity<TeamDto> deleteTeamUsingName(@PathVariable String name){
        teamService.deleteUsingName(name);
        return new ResponseEntity<TeamDto>(HttpStatus.OK);
    }


}
