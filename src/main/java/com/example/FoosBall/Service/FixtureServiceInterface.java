package com.example.FoosBall.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.FoosBall.Dtos.FixturesDto;



public interface FixtureServiceInterface {
	

	 String addMatchwithavailableTeamids(Long id, Long id1);
		
	 
	 String	addWinnerteamidwithmatchid(Long idwinner,  Long idfixture);	
		
	
	 String randomFixtureswithAvailableteams(); 
	 
	 
	 FixturesDto deletefixture(Long id);
	 
	 
	 String deleteallfixture();
	  
	  
	 List<FixturesDto> getallFixtureswithteams(); 
	 
	 
	 FixturesDto getFixturebyid(Long id);
	  
	  
	 String updateFixturebyid(FixturesDto fixdto , Long id);
	 
	 
	 String fixturesDate_TimeSet(int matchesperday,int stdate, int endate , int stmonth, int endmonth, int year, int stTime, int enTime,int gapInminutes);
		
	
}
