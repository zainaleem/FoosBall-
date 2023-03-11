package com.example.FoosBall.Repository;

import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Entity.PlayerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDetailsRepo extends JpaRepository<PlayerDetails,Long> {

    PlayerDetails findByPlayerName(String name);
}
