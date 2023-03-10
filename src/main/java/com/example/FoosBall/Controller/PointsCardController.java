package com.example.FoosBall.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoosBall.Dtos.PointsCardDto;
import com.example.FoosBall.Service.PointsCardInterface;



//import com.example.Service.PointsTableService;

@RestController
public class PointsCardController {
	
	@Autowired
	PointsCardInterface pointsCardservice;
	
	@PostMapping("/update_Pointstable")
	public ResponseEntity<String> update_Pointstable() {
	return new ResponseEntity<>( pointsCardservice.updatePointstable(), HttpStatus.OK);
	}
	
	
	@GetMapping("/get_all_points_list")
	public ResponseEntity<List<PointsCardDto>> get_teams(){
	return new ResponseEntity<>(pointsCardservice.getallPointslist(),HttpStatus.OK);
	}
	
	
	@GetMapping("get_points_by_id/{id}")
	public ResponseEntity<PointsCardDto> get_team_by_id(@PathVariable Long id){
	return new ResponseEntity<>( pointsCardservice.getPointsbyid(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("delete_points_by_id/{id}")
	public ResponseEntity<PointsCardDto> delete_student(@PathVariable Long id){
	return new ResponseEntity<> (pointsCardservice.deletepointsCardbyId(id),HttpStatus.OK);
	}

	
	@DeleteMapping("delete_all_Points")
	public ResponseEntity<String> deleteallfixture(){
	return new ResponseEntity<>( pointsCardservice.deleteAllPointslist(),HttpStatus.OK);
	}
	
	
	

}
