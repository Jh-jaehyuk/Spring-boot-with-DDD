package com.practice.second.player.controller.request_form;

import com.practice.second.player.service.request.PlayerCreateRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlayerCreateRequestForm {
    private final String name;

    public PlayerCreateRequest toPlayerCreateRequest() {
        return new PlayerCreateRequest(this.name);
    }
}
