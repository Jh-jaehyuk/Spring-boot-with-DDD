package com.practice.second.player.service.request;

import com.practice.second.player.entity.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlayerCreateRequest {
    private final String name;

    public Player toPlayer() {
        return new Player(this.name);
    }
}
