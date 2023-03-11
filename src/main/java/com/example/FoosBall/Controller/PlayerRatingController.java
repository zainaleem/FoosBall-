package com.example.FoosBall.Controller;

import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Dtos.PlayerRatingDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.PlayerRating;
import com.example.FoosBall.Repository.FixturesRepository;
import com.example.FoosBall.Repository.PlayerRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PlayerRatingController {

    @Autowired
    PlayerRatingRepository playerRatingRepo;


    @PostMapping("/player/rating")
    public ResponseEntity<PlayerRatingDto> addPlayerRatings(@RequestBody PlayerRatingDto playerRatingDto) {
        PlayerRating playerRating = null;
        playerRating.setMatchesWon(playerRatingDto.getMatchesWon());
        playerRating.setTotalMatches(playerRatingDto.getTotalMatches());
        playerRating.setWinPercentage((playerRatingDto.getMatchesWon() / playerRatingDto.getTotalMatches())*100);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/player/rating/{id}")
    public ResponseEntity<PlayerRating> addPlayerRatings(@PathVariable Long id, @RequestBody PlayerRatingDto playerRatingDto) {

//        PlayerRatingDto updateDto = playerRatingService.update(id, playerRatingDto);
        Optional<PlayerRating> playerRatingOptional = playerRatingRepo.findById(id);
        PlayerRating playerRating = null;
        if (playerRatingOptional.isPresent()) {
            playerRating = playerRatingOptional.get();
            playerRating.setTotalMatches(playerRatingDto.getTotalMatches());
            playerRating.setMatchesWon(playerRatingDto.getMatchesWon());
            playerRating.setWinPercentage((playerRatingDto.getMatchesWon() / playerRatingDto.getTotalMatches())*100);

        }
        PlayerRating updatedDao = playerRatingRepo.save(playerRating);
        return new ResponseEntity<>(updatedDao, HttpStatus.OK);
        }
}