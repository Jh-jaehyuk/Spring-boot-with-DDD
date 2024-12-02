package com.example.demo.player.service;

import com.example.demo.player.entity.Player;
import com.example.demo.player.service.request.PlayerCreateRequest;
import com.example.demo.player.service.request.PlayerFindRequest;
import com.example.demo.player.service.response.PlayerCreateResponse;
import com.example.demo.player.service.response.PlayerListResponse;

import java.util.List;

public interface PlayerService {
    PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest);
    Player findPlayer(PlayerFindRequest playerFindRequest);
//    List<PlayerListResponse> listPlayer();
}