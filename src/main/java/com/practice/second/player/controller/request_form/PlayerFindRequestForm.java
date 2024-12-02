package com.practice.second.player.controller.request_form;

import com.practice.second.player.service.request.PlayerFindRequest;
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
