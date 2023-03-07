package com.example.FoosBall.Controller;

import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foosball")
public class PlayerController {

    @Autowired
    PlayerServiceImpl playerService;

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDto>> getPlayers() {
        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/player/{name}")
    public ResponseEntity<PlayerDto> getPlayerByName(@PathVariable String name) {
        return new ResponseEntity<>(playerService.findByPlayerName(name), HttpStatus.OK);
    }

    @GetMapping("/players/team/{teamName}")
    public ResponseEntity<List<PlayerDto>> getPlayerByTeamName(@PathVariable String teamName) {
        return new ResponseEntity<>(playerService.findByTeamName(teamName), HttpStatus.OK);
    }

    @PostMapping("/player")
    public ResponseEntity<PlayerDto> addPlayers(@RequestBody PlayerDto playerDto) {

        try{
            playerService.add(playerDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NameException nameException){
            nameException.printStackTrace();
            nameException.getMessage();
            return null;
        }
    }
}
