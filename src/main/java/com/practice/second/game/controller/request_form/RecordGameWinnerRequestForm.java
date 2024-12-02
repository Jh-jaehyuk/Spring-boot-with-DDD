package com.practice.second.game.controller.request_form;

import com.practice.second.game.service.request.RecordGameWinnerRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerRequestForm {
    private final Long gameId;

    public RecordGameWinnerRequest toRecordGameWinnerRequest() {
        return new RecordGameWinnerRequest(this.gameId);
    }
}
