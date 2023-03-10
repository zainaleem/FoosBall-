package com.example.FoosBall.Repository;

import com.example.FoosBall.Dtos.PlayerDto;
import com.example.FoosBall.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {


    @Query(value = "SELECT p.player_name FROM Player p",nativeQuery = true)
    List<String> findAllNames();
    Optional<Player> findByName(String name);
    List<Player> findByTeamName(String name);



}
