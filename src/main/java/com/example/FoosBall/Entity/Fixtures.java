package com.example.FoosBall.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;




@Entity
//@Table(name = "\"Match\"")//name = "\"Match\""
public class Fixtures {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Match_id")
	private Long Match_Id;
	
	@Column(name = "Match_Date")
    private	 LocalDate Match_Date;
	
	@Column(name = "Match_Time")
    private  LocalTime Match_Time;
	
    //@OneToOne	
	
	@Column(name = "Team_A")
    private String Team_A;
	
//	
//	@Column(name = "Versus")
//    private String Vs = "VS";
	
	
	@Column(name = "Team_B")
    private String  Team_B;
	
	
//	@Column(name = "Winner_Team_Id")
//    private Long Winner_Team_Id;

	@Column(name = "Winner_Team_Name")
	private String Winner_Team_Name;
//	@OneToOne()
//	@Column(name = "Loosing_Team_Id")
//    private Long Loosing_Team_Id;
//
	@Column(name = "Loosing_Team_Name")
	private String Loosing_Team_Name;

	@ManyToMany()//fetch = FetchType.LAZY)
	@JoinTable(
	name = "Team_vs_Team", 
	joinColumns = @JoinColumn(name = "Match_Id"), 
	inverseJoinColumns = @JoinColumn(name = "Team_Id"))
	@Column(name = "Team")
	private  List <Team> Team_vs_Team;


	public Fixtures(Long match_Id, LocalDate match_Date, LocalTime match_Time, String team_A, String team_B,
			String winner_Team_Name, String loosing_Team_Name, List<Team> team_vs_Team) {
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



	public Fixtures() {
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

	public List<Team> getTeam_vs_Team() {
		return Team_vs_Team;
	}

	public void setTeam_vs_Team(List<Team> team_vs_Team) {
		Team_vs_Team = team_vs_Team;
	}

		}