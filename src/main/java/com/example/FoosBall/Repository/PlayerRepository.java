package com.example.FoosBall.Repository;

import com.example.FoosBall.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
