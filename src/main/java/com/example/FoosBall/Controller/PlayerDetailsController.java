package com.example.FoosBall.Controller;

import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.PlayerDetails;
import com.example.FoosBall.Repository.PlayerDetailsRepo;
import com.example.FoosBall.Service.PlayerDetailsServiceImpl;
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
public class PlayerDetailsController {

    @Autowired
    PlayerDetailsRepo playerDetailsRepo;

    @Autowired
    PlayerDetailsServiceImpl playerDetailsService;

    @PostMapping("/player/details/import")
    public ResponseEntity<String> importData(@RequestParam("file") MultipartFile file) /*throws IOException*/ {
        try {
            List<PlayerDetails> playerDetailsList = new ArrayList<>();
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                PlayerDetails playerDetails = new PlayerDetails();
                playerDetails.setPlayerName(row.getCell(0).getStringCellValue());
                playerDetails.setCellNumber(row.getCell(1).getStringCellValue());
                playerDetails.setEmail(row.getCell(2).getStringCellValue());
                playerDetailsList.add(playerDetails);
            }
            workbook.close();
            playerDetailsRepo.saveAll(playerDetailsList);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(playerDetailsList);
            return ResponseEntity.ok(json);
        } catch (IOException ioException) {
            System.out.println("IO Exception");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
