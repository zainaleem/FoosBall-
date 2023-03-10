package com.example.FoosBall.Service;

import java.util.List;

import com.example.FoosBall.Dtos.PointsCardDto;


public interface PointsCardInterface {
	
	 String updatePointstable();
	
	 
	 List<PointsCardDto> getallPointslist();
	
	
	 PointsCardDto getPointsbyid(Long id);

	 
	 PointsCardDto updateteambyid(PointsCardDto pointstdto , Long id);
	 
	 
	 PointsCardDto deletepointsCardbyId(Long id);
	 
	 
	 String deleteAllPointslist();
}
