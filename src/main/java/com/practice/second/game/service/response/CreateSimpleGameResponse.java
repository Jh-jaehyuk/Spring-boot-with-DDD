package com.practice.second.game.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateSimpleGameResponse {
    private final int gameId;
    private final boolean success;

    public static CreateSimpleGameResponse from(int gameId) {
        if (gameId <= 0) {
            return new CreateSimpleGameResponse(-1, false);
        }

        return new CreateSimpleGameResponse(gameId, true);
    }
}
