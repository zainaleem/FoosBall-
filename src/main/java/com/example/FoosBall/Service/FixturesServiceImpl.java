package com.example.FoosBall.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoosBall.Dtos.FixturesDto;
import com.example.FoosBall.Dtos.TeamDto;
import com.example.FoosBall.Entity.Fixtures;
import com.example.FoosBall.Entity.Team;
import com.example.FoosBall.Repository.FixturesRepository;
import com.example.FoosBall.Repository.TeamRepository;



@Service
public class FixturesServiceImpl implements FixtureServiceInterface{
	
	
	
	@Autowired
	private FixturesRepository matchRepo;
	
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	
	public String addMatchwithavailableTeamids(Long id, Long id1) {
	//	
		List<Team> teams = new ArrayList<>();
    Optional<Team> teamOp1 = teamRepo.findById(id);
    Optional<Team> teamOp2 = teamRepo.findById(id1);
    
if(teamOp1.isPresent()||teamOp2.isPresent()) {	
	Team team1 = teamOp1.get();
	Team team2 = teamOp2.get();
	teams.add(team1);
	teams.add(team2);
   // Fixtures  fixture  = modelmapper.map(fixturedto, Fixtures.class);
    Fixtures fixture = new Fixtures();
	fixture.setTeam_vs_Team(teams);
	fixture.setTeam_A("Id_"+team1.getId().toString()+" "+team1.getName());
	fixture.setTeam_B("Id_"+team2.getId().toString()+" "+team2.getName());
	matchRepo.save(fixture);
}	
	return "No such team Available";
		
	}
	
	
	
	
	
	public String addWinnerteamidwithmatchid(Long idwinner,  Long idfixture) {
	
  Optional <Fixtures> match = Optional.ofNullable(matchRepo.findById(idfixture).orElseThrow());
	
   if(match.isPresent()) {
   Fixtures fixture = match.get();
   List<Team> teams = fixture.getTeam_vs_Team();
	
   for( Team team : teams) {
	   if (team.getId()==idwinner){ //objects.equal()
		 //fixture.setWinner_Team_Id(team.getId());
		   fixture.setWinner_Team_Name("Id_"+team.getId().toString()+" "+team.getName());
	   }
	else if (team.getId()!=idwinner) {
		//fixture.setLoosing_Team_Id(team.getId());
		fixture.setLoosing_Team_Name("Id_"+team.getId().toString()+" "+team.getName());
		    //matchRepo.save(match);
		} 
	} 
	
	//match.setLoosing_Team_Id(loserId);
	//match.setWinner_Team_Id(winnerId);
	//match.setLoosing_Team_Id(fixture.getLoosing_Team_Id());   check after test
	//match.setWinner_Team_Id(fixture.getWinner_Team_Id());     check after test
	matchRepo.save(fixture);
	
	 return "message sent";
   } 
	
     return "no such match available";

	}
	

	
	
	
	
	public String randomFixtureswithAvailableteams() {
	
	List<Team> list = teamRepo.findAll();
	Set<Fixtures> randomMatches = new HashSet<>();
	List<Team> teamsReapeat = new ArrayList<>();
	int size =  list.size();//-1;
    Collections.shuffle(list);
	int count = 0;

   while(count<size) {
	  Team Team = list.get(count);

outer:for(Team teams :list) {
	    Fixtures match = new Fixtures();
		if(teams.getId()!=Team.getId()) {
		  if(teamsReapeat.size()!=0) {			
 		    for(Team matching:teamsReapeat)	{
 			  if(matching.getId()==teams.getId()) {
		    	continue outer;       
 			  } 
    	   }
 		 }  
    	 List<Team> twoTeams = new ArrayList<>();
    	 match.setTeam_A("Id_"+Team.getId().toString()+" "+Team.getName());      //  bare if ka samaan
         match.setTeam_B("Id_"+Team.getId().toString()+" "+teams.getName());
         twoTeams.add(Team);
         twoTeams.add(teams);
         match.setTeam_vs_Team(twoTeams);
         if(match.getTeam_A()!=null) {       //this is main
           randomMatches.add(match);
          }
       }	 
    	 
     }
	   teamsReapeat.add(Team);
	   count++; 
   }
       List<Fixtures> allTeams = new ArrayList<>(randomMatches);
       Collections.shuffle(allTeams);
       matchRepo.saveAll(allTeams);
	   return "message sent";   
}

  
	
	
	public FixturesDto deletefixture(Long id){
	FixturesDto dt = modelmapper.map(matchRepo.findById(id), FixturesDto.class);
	matchRepo.deleteById(id);
	return dt;
	}
	
	
	
	public String deleteallfixture(){
	//	FixturesDto dt = modelmapper.map(matchRepo.findById(id), FixturesDto.class);
		matchRepo.deleteAll();
		return "done";
	}
	
	
	
 	public List<FixturesDto> getallFixtureswithteams()  {
	List<Fixtures> list = matchRepo.findAll();
	List<FixturesDto> dto_list = new ArrayList<>();
	for(Fixtures a: list) {
		List <TeamDto> ch = new ArrayList<>();
	try { List <Team> c = a. getTeam_vs_Team();
		   for( Team p :c) {
	         TeamDto  d = modelmapper.map(p , TeamDto.class);
              ch.add(d);
		   }
		
     } catch(IllegalArgumentException e) {
       ch.add(null);
	   System.out.println("null value");
	   }
    
	  FixturesDto b = modelmapper.map(a, FixturesDto.class);
      b.setTeam_vs_Team(ch);
      dto_list.add(b);
     
	}
	   return dto_list;
}
 	
 	
 	
 	public FixturesDto getFixturebyid(Long id) {
 		
 		Optional<Fixtures> fixtureop = Optional.ofNullable(matchRepo.findById(id).orElseThrow());
 		
 		if(fixtureop.isPresent()) {
 			
 		Fixtures fixture = fixtureop.get();
 		List<TeamDto> team = new ArrayList<>();
 		try {List<Team> teamlist = fixture.getTeam_vs_Team();
 		for(Team teamGet : teamlist ) {
 		TeamDto mod = modelmapper.map(teamGet , TeamDto.class);
 		team.add(mod);
 		}
 		} catch(IllegalArgumentException e) {
 	   	  team.add(null);
 			System.out.println("null value");
 		}
 		
 		FixturesDto fixTure = modelmapper.map(fixture, FixturesDto.class);
 		fixTure.setTeam_vs_Team(team);
 		return fixTure;
 		}
 		 
 		return null;
 	}
       
	
 	
 	
 	
 	public String fixturesDate_TimeSet(int matchesperday,int stdate, int endate , int stmonth, int endmonth, int year, int stTime, int enTime,int gapInminutes) {
 	  
 	   LocalDate startDate = LocalDate.of(2000+year,stmonth, stdate); // start date
       LocalDate endDate = LocalDate.of(2000+year, endmonth, endate); // end date
       long daysBetween = ChronoUnit.DAYS.between(startDate, endDate); // total number of days between start and end date
   
       LocalTime startTime = LocalTime.of(stTime, 0); // start time
       LocalTime endTime = LocalTime.of(enTime, 0); // end time
       long minutesBetween = ChronoUnit.MINUTES.between(startTime, endTime); // total number of minutes between start and end time

        int gapInMinutes = gapInminutes; // gap between each possible time, in minutes
    
        List<Fixtures> fixtureList = matchRepo.findAll();
	
	
	
    int count = 0;
	int user  = 0;
	
	LocalDate Date = startDate.plusDays(user); // add the random number of days to the start date to get a random date
	LocalTime Time = startTime.plusMinutes( gapInMinutes * user);  
		   for( Fixtures fixture :fixtureList ) {
			//if(daysBetween!=user) {
			 if(count!=matchesperday) {
			   if(fixture.getTeam_A()!=null) { 
				   fixture.setMatch_Date(Date);
				   fixture.setMatch_Time(Time);
				   count++;
				}
		      }
			   else {  
				   count=0;
				   user++;
			   }
		   }   
		return "date and time set";		   		
	   
 	}			 
	  
		
 	
 public String updateFixturebyid(FixturesDto fixdto , Long id){
 	 Optional <Fixtures> fixture =  matchRepo.findById(id);
 	 
 	
	// PointsCard dt = modelmapper.map(st, TeamDto.class);
    if(fixture.isPresent()){
	  Fixtures fixturedao  =  fixture.get();
	
	  if(fixdto.getLoosing_Team_Name()!=null)
		fixturedao.setLoosing_Team_Name(fixdto.getLoosing_Team_Name());
		
	  if(fixdto.getTeam_A()==null)
		fixturedao.setTeam_A(fixturedao.getTeam_A());
		
		
	  if(fixdto.getTeam_B()==null)
	    fixturedao.setTeam_B(fixturedao.getTeam_B());
			
	  if(fixdto.getWinner_Team_Name()==null)
		fixturedao.setWinner_Team_Name(fixturedao.getWinner_Team_Name());	
	  
	  matchRepo.save(fixturedao);
	} 
    
    return "message sent";
 }  

 	
 	



}
