package com.example.FoosBall.Dtos;



public class PointsCardDto {
	
	private Long Position;
   
	
	private String TeamName;
    
   
	private Long Points;


	public PointsCardDto(Long position, String teamName, Long points) {
		super();
		Position = position;
		TeamName = teamName;
		Points = points;
	}


	public PointsCardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getPosition() {
		return Position;
	}


	public void setPosition(Long position) {
		Position = position;
	}


	public String getTeamName() {
		return TeamName;
	}


	public void setTeamName(String teamName) {
		TeamName = teamName;
	}


	public Long getPoints() {
		return Points;
	}


	public void setPoints(Long points) {
		Points = points;
	}


	
	
	

}
