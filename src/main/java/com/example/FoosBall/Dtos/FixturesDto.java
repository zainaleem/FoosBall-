package com.example.FoosBall.Dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;





public class FixturesDto {
	
	
	
	private Long Match_Id;
	
	
    private	 LocalDate Match_Date;
	
	
    private  LocalTime Match_Time;
	
   
    private String Team_A;
	

	private String  Team_B;
	
	
	private String Winner_Team_Name;
	
	
	private String Loosing_Team_Name;
	
	
	
	private  List <TeamDto> Team_vs_Team;



	public FixturesDto(Long match_Id, LocalDate match_Date, LocalTime match_Time, String team_A, String team_B,
			String winner_Team_Name, String loosing_Team_Name, List<TeamDto> team_vs_Team) {
		super();
		Match_Id = match_Id;
		Match_Date = match_Date;
		Match_Time = match_Time;
		Team_A = team_A;
		Team_B = team_B;
		Winner_Team_Name = winner_Team_Name;
		Loosing_Team_Name = loosing_Team_Name;
		Team_vs_Team = team_vs_Team;
	}



	public FixturesDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getMatch_Id() {
		return Match_Id;
	}



	public void setMatch_Id(Long match_Id) {
		Match_Id = match_Id;
	}



	public LocalDate getMatch_Date() {
		return Match_Date;
	}



	public void setMatch_Date(LocalDate match_Date) {
		Match_Date = match_Date;
	}



	public LocalTime getMatch_Time() {
		return Match_Time;
	}



	public void setMatch_Time(LocalTime match_Time) {
		Match_Time = match_Time;
	}



	public String getTeam_A() {
		return Team_A;
	}



	public void setTeam_A(String team_A) {
		Team_A = team_A;
	}



	public String getTeam_B() {
		return Team_B;
	}



	public void setTeam_B(String team_B) {
		Team_B = team_B;
	}



	public String getWinner_Team_Name() {
		return Winner_Team_Name;
	}



	public void setWinner_Team_Name(String winner_Team_Name) {
		Winner_Team_Name = winner_Team_Name;
	}



	public String getLoosing_Team_Name() {
		return Loosing_Team_Name;
	}



	public void setLoosing_Team_Name(String loosing_Team_Name) {
		Loosing_Team_Name = loosing_Team_Name;
	}



	public List<TeamDto> getTeam_vs_Team() {
		return Team_vs_Team;
	}



	public void setTeam_vs_Team(List<TeamDto> team_vs_Team) {
		Team_vs_Team = team_vs_Team;
	}





}