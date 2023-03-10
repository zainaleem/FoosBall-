package com.example.FoosBall.Repository;

import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.Team;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    Team findByName(String name);
    
    
    @Query(value = "SELECT team_name FROM team",nativeQuery = true)
	List<String> findByName();
}
