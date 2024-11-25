package com.practice.first.player.service;


import com.practice.first.player.entity.Player;
import com.practice.first.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    final private PlayerRepository playerRepository;

    @Override
    public Player createPlayer() {
        return playerRepository.create();
    }
}
