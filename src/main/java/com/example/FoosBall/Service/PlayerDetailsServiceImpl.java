package com.example.FoosBall.Service;

import com.example.FoosBall.Dtos.PlayerDetailsDto;
import com.example.FoosBall.Entity.Player;
import com.example.FoosBall.Entity.PlayerDetails;
import com.example.FoosBall.Repository.PlayerDetailsRepo;
import com.example.FoosBall.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
public class PlayerDetailsServiceImpl implements Service<PlayerDetailsDto>{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerDetailsRepo playerDetailsRepo;

    @Override
    public List<PlayerDetailsDto> findAll() {
        return null;
    }

    @Override
    public PlayerDetailsDto add(PlayerDetailsDto dto) {
        return null;
    }

    @Override
    public void deleteUsingId(Long id) {

    }
    @Override
    public void deleteUsingName(String name) {

    }

    @Override
    public PlayerDetailsDto update(Long id, PlayerDetailsDto dto) {
        return null;
    }

    @Override
    public PlayerDetailsDto patch(Long id, PlayerDetailsDto dto) {
        return null;
    }

}
