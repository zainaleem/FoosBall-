package com.example.FoosBall.Repository;

import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    Team findByName(String name);
}
