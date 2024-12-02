package com.practice.second.game.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckGameRequest {
    private final Long gameId;
}
