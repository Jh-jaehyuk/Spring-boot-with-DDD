package com.example.demo.player.controller.request_form;

import com.example.demo.player.service.request.PlayerCreateRequest;
import com.example.demo.player.service.request.PlayerFindRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerFindRequestForm {
    private final Long playerId;

    public PlayerFindRequest toPlayerFindRequest() {
        return new PlayerFindRequest(this.playerId);
    }
}