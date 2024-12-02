package com.practice.second.game.controller.response_form;

import com.practice.second.game.service.response.CreateSimpleGameResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateSimpleGameResponseForm {
    private final int gameId;
    private final boolean success;

    public static CreateSimpleGameResponseForm from(CreateSimpleGameResponse createSimpleGameResponse) {
        return new CreateSimpleGameResponseForm(createSimpleGameResponse.getGameId(), createSimpleGameResponse.isSuccess());
    }
}
