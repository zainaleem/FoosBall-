package com.example.FoosBall.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PointsCard {
	
	

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "position")
   private Long Position;
	
	
   @Column(name = "team_name")
   private String TeamName;
    
   @Column(name = "points")
   private Long Points;

	public PointsCard(Long position, String teamName, Long points) {
		super();
		Position = position;
		TeamName = teamName;
		Points = points;
	}

	public PointsCard() {
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