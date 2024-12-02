package com.example.demo.player.controller.request_form;

import com.example.demo.player.service.request.PlayerCreateRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerCreateRequestForm {
    private final String name;

    public PlayerCreateRequest toPlayerCreateRequest() {
        return new PlayerCreateRequest(this.name);
    }
}