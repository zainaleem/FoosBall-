package com.example.FoosBall.Controller;

import java.util.List;

import javax.persistence.PostUpdate;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoosBall.Dtos.FixturesDto;
import com.example.FoosBall.Service.FixtureServiceInterface;


//import com.example.Final.controller.Match_interface;
//import com.example.Final.dto.Match_dto;


@RestController
public class FixturesController {
	
	
	@Autowired
	FixtureServiceInterface matchService;
	

	@PostMapping("/add_match_with_available_Team_id/{id}/{id1}")
	public ResponseEntity<String> add_match_with_teams( @PathVariable Long id,@PathVariable Long id1) {
		return new ResponseEntity<>(matchService.addMatchwithavailableTeamids(id,id1),HttpStatus.OK);
	}

	@PutMapping("/add_Winner_team_id_with_match_id/{idwinner}/{idfixture}")
	public ResponseEntity<String> addWinnerteamwithmatch(@PathVariable Long idwinner,@PathVariable Long idfixture) {
	return new ResponseEntity<>(matchService.addWinnerteamidwithmatchid(idwinner,idfixture), HttpStatus.OK) ;
	}
	
	
	@PostMapping("/randomFixtureswithAvailableteams")
	public ResponseEntity<String> randomFixtureswithAvailableteams() {
	return new ResponseEntity<>(matchService.randomFixtureswithAvailableteams(),HttpStatus.OK);
	}
	
	
	

	@PostMapping("fixturesDate_TimeSet/{matchesperday}/{stdate}/{endate}/{stmonth}/{endmonth}/{year}/{stTime}/{enTime}/{gapInminutes}")
	public ResponseEntity<String> fixturesDate_TimeSet(@PathVariable int matchesperday,@PathVariable int stdate,@PathVariable int endate, @PathVariable int stmonth, @PathVariable int endmonth, @PathVariable int year, @PathVariable int stTime, @PathVariable  int enTime, @PathVariable int gapInminutes) {
	return new ResponseEntity<>(matchService.fixturesDate_TimeSet(matchesperday, stdate, endate , stmonth, endmonth, year, stTime,  enTime, gapInminutes), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/get_all_matches")
	public ResponseEntity<List<FixturesDto>> get_matches(){
	return new ResponseEntity<>(matchService.getallFixtureswithteams(),HttpStatus.OK);
	}

	
	
	@GetMapping("get_match_by_id/{id}")
	public ResponseEntity<FixturesDto> get_match_by_id(@PathVariable Long id){
	return new ResponseEntity<>( matchService.getFixturebyid(id), HttpStatus.OK);
	}

	
	@PutMapping("update_match_by_id/{id}")
	public ResponseEntity<String> update_match(@RequestBody FixturesDto fixdto, @PathVariable Long id) {
	return new ResponseEntity<> (matchService.updateFixturebyid(fixdto , id), HttpStatus.OK);
    }
     
	
	@DeleteMapping("delete_match_by_id/{id}")
	public ResponseEntity<FixturesDto> deletefixture(@PathVariable Long id){
	return new ResponseEntity<> (matchService.deletefixture(id), HttpStatus.OK);
	}


	@DeleteMapping("delete_all_fixture")
	ResponseEntity<String> deleteallfixture(){
	return new ResponseEntity<>( matchService.deleteallfixture(),HttpStatus.OK);
	}

	
	

}
