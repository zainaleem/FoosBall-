package com.example.FoosBall.Controller;

import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.PlayerDetails;
import com.example.FoosBall.Exception.NameException;
import com.example.FoosBall.Exception.RecordNotFoundException;
import com.example.FoosBall.Repository.PlayerRepository;
import com.example.FoosBall.Service.PlayerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    PlayerServiceImpl playerService;

    @Autowired
    PlayerRepository playerRepository;

    @PostMapping("/player/import")
    public ResponseEntity<String> importData(@RequestParam("file") MultipartFile file) /*throws IOException*/ {
        try{
        List<Player> playerList = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            Player player = new Player();
            PlayerDetails playerDetails = new PlayerDetails();
            player.setName(row.getCell(0).getStringCellValue());
            playerList.add(player);
        }
            workbook.close();
            playerRepository.saveAll(playerList);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(playerList);
            return ResponseEntity.ok(json);
        }
        catch (IOException ioException){
            System.out.println("IO Exception");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        }
    @GetMapping("/players")
    public ResponseEntity<List<PlayerDto>> getPlayers() {
        //return new ResponseEntity<>(playerRepo.findAllNames(), HttpStatus.OK);
        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/player/names")
    public ResponseEntity<List<String>> getPlayerNames() {
        return new ResponseEntity<>(playerService.findAllPlayerNames(), HttpStatus.OK);

    }
    @GetMapping("/player/{name}")
    public ResponseEntity<PlayerDto> getPlayerByName    (@PathVariable String name) {
        try{
            PlayerDto playerDto = playerService.findByPlayerName(name);
            return new ResponseEntity<>(playerDto,HttpStatus.OK);
        }
        catch (RecordNotFoundException recordNotFoundException){
            System.out.println(recordNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto)
    {
        playerService.update(id,playerDto);
        return new ResponseEntity<PlayerDto>(HttpStatus.OK);
    }

    @PutMapping("/player/details")
    public ResponseEntity<PlayerDto> updatePlayerWithDetails(@RequestBody PlayerDto playerDto){
        PlayerDto updateDto = playerService.updatePlayerDetails(playerDto);
        return new ResponseEntity<PlayerDto>(updateDto,HttpStatus.OK);
    }

    @PatchMapping("/player/{id}")
    public PlayerDto patchPlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return playerService.patch(id, playerDto);
    }

    @DeleteMapping("/player/id/{id}")
    public ResponseEntity<PlayerDto> deletePlayer(@PathVariable Long id){
        playerService.deleteUsingId(id);
        return new ResponseEntity<PlayerDto>(HttpStatus.OK);
    }
    @DeleteMapping("/player/name/{name}")
    public ResponseEntity<PlayerDto> deletePlayerUsingName(@PathVariable String name){
        try{
            playerService.deleteUsingName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (RecordNotFoundException recordNotFoundException){
            System.out.println(recordNotFoundException.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
