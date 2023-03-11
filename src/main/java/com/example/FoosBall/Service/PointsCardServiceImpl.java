package com.example.FoosBall.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoosBall.Dtos.PointsCardDto;
import com.example.FoosBall.Entity.PointsCard;
import com.example.FoosBall.Repository.FixturesRepository;
import com.example.FoosBall.Repository.PointsCardRepository;
import com.example.FoosBall.Repository.TeamRepository;

import org.modelmapper.ModelMapper;



@Service
public class PointsCardServiceImpl implements PointsCardInterface {

	@Autowired
    FixturesRepository MatchRepo;

	@Autowired
	PointsCardRepository PointsRepo;

	@Autowired
	TeamRepository TeamRepo;

	@Autowired
	ModelMapper modelmapper;

	public String updatePointstable() {

    List<String> teamListfromTeam = TeamRepo.findByName();
    List<String> teamListfromMatch = MatchRepo.findByWinner_Team_Name();
    List<PointsCard> pointsCardlist = new ArrayList<>();
    long count = 0;
     for( String team1 : teamListfromTeam) {
      if(team1!=null) {
    	 for( String team2 : teamListfromMatch) {
    	  if(team2 != null) {
    		if (team1.compareTo(team2)==0) {
    			count++;
    		}
    	  }
    	 }
    	 PointsCard pointsCard = new PointsCard();
    	 pointsCard.setPoints(count);
    	 pointsCard.setTeamName(team1);
    	 pointsCardlist.add(pointsCard);
          count = 0;
      }
	}

	Collections.sort(pointsCardlist, new Comparator<PointsCard>(){
		public int compare(PointsCard ob, PointsCard ob1){
			 if(ob.getPoints().compareTo(ob1.getPoints())<0){
				 return 1;
			}
			 if(ob.getPoints().compareTo(ob1.getPoints())>0)
				 return -1;
			 else
				 return 0;
			 }
		 });
	PointsRepo.saveAll(pointsCardlist);
	return "message sent";
}




	public List<PointsCardDto> getallPointslist()  {
	  List<PointsCard> list = PointsRepo.findAll();
	  List<PointsCardDto> pointsCarddto_list = new ArrayList<>();
	  for(PointsCard points: list) {
		//	TeamDto d;
		try {  PointsCardDto  map = modelmapper.map(points , PointsCardDto.class);
		      pointsCarddto_list.add(map);
	    } catch(IllegalArgumentException e) {
	    	 pointsCarddto_list.add(null);
			System.out.println("null value");
		}
	  }
		return pointsCarddto_list;
	}



	public PointsCardDto getPointsbyid(Long id) {
		Optional<PointsCard> pointsCard = PointsRepo.findById(id);
		PointsCard Pointscard = pointsCard .orElseThrow();
		PointsCardDto points = modelmapper.map(Pointscard , PointsCardDto.class);
	    return points;
	}
//		} catch(IllegalArgumentException e) {
//	   	  System.out.println("null value");
//	   	  return null;
//		}


	public PointsCardDto updateteambyid(PointsCardDto pointstdto , Long id){
	Optional <PointsCard> points = PointsRepo.findById(id);
		// PointsCard dt = modelmapper.map(st, TeamDto.class);
	if(points.isPresent()){
		PointsCard pointsCard  =  points.get();

		if(pointstdto.getPoints()!=null) {
		   pointsCard.setPoints(id);
		}
		if(pointstdto.getPosition()!=null) {
		  pointsCard.setPosition(pointstdto.getPosition());
		}

		if(pointstdto.getTeamName()!=null) {
		  pointsCard.setTeamName(pointstdto.getTeamName());
		}
		PointsRepo.save(pointsCard);

    }
		return pointstdto;
	}


	public PointsCardDto deletepointsCardbyId(Long id){
		PointsCardDto points = modelmapper.map(PointsRepo.findById(id), PointsCardDto.class);
		PointsRepo.deleteById(id);
		return points;
	}

	 public String deleteAllPointslist(){
		//PointsCardDto pointscard = modelmapper.map(PointsRepo.findById(id), PointsCardDto.class);
		PointsRepo.deleteAll();
		return "message sent";

		}








}
