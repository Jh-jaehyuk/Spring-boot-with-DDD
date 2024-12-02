package com.practice.second.player.service;

import com.practice.second.player.entity.Player;
import com.practice.second.player.service.request.PlayerCreateRequest;
import com.practice.second.player.service.request.PlayerFindRequest;
import com.practice.second.player.service.response.PlayerCreateResponse;
import com.practice.second.player.service.response.PlayerListResponse;

import java.util.List;

public interface PlayerService {
    PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest);
    Player findPlayer(PlayerFindRequest playerFindrequest);
    List<PlayerListResponse> listPlayer();
}
