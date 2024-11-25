package com.practice.first.player.controller;

import com.practice.first.player.entity.Player;
import com.practice.first.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/first-player")
public class PlayerController {
    final private PlayerService playerService;

    @GetMapping("/create-player")
    public Player createPlayer() {
        log.info("createPlayer() called!");

        return playerService.createPlayer();
    }
}
