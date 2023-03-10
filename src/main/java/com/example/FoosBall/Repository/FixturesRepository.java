package com.example.FoosBall.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FoosBall.Entity.Fixtures;




   public interface FixturesRepository extends JpaRepository<Fixtures,Long> {
	   
	   @Query(value = "SELECT Winner_Team_Name FROM fixtures",nativeQuery = true)
	   List<String> findByName();
	
	  
	   @Query(value = "SELECT Team_A FROM fixtures",nativeQuery = true)
	   List<String> findByTeamName();
	   
	  
	   
	   
	}


