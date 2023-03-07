package com.example.FoosBall.Controller;

import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

}
